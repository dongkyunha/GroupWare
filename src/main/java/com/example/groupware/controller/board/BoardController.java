package com.example.groupware.controller.board;

import com.example.groupware.container.ResultSet;
import com.example.groupware.entity.board.BoardMasterVO;
import com.example.groupware.entity.board.RequestBoard;
import com.example.groupware.service.board.BoardService;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //clean code
    @GetMapping(value = "/list")
    public ModelAndView findBoardAllWhere(ModelAndView mav, RequestBoard request, @PageableDefault Pageable pageable){

        pageable = PageRequest.of(pageable.getPageNumber() != 0 ? pageable.getPageNumber() -1 : 0, pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "boardNo"));
        Page<BoardMasterVO> pageList = boardService.findAllWhere(request, pageable);

        mav.setViewName("board/list");
        mav.addObject("boardList", pageList);
        mav.addObject("boardListCnt", pageList.getTotalElements());
        mav.addObject("today", LocalDateTime.now());
        mav.addObject("size", pageable.getPageSize());
        mav.addObject("searchList", request);

        return mav;
    }

    @GetMapping(value = "/list3")
    public ModelAndView findBoardAllWhereMultipleOrder(ModelAndView mav, RequestBoard request,
        @SortDefault.SortDefaults({
                @SortDefault(sort = "boardNo", direction = Sort.Direction.DESC),
                @SortDefault(sort = "boardTitle", direction = Sort.Direction.DESC)
        }) Pageable pageable){

        pageable = PageRequest.of(pageable.getPageNumber() != 0 ? pageable.getPageNumber() -1 : pageable.getPageNumber(),10, Sort.by("boardNo").descending().and(Sort.by("boardTitle")));
        Page<BoardMasterVO> pageList = boardService.findAllWhere(request, pageable);

        mav.setViewName("board/list");
        mav.addObject("boardList", pageList);
        mav.addObject("today", LocalDateTime.now());

        return mav;
    }

    @RequestMapping(value ="/list2", method = RequestMethod.GET)
    public ModelAndView findBoardAll(ModelAndView mav, @PageableDefault Pageable pageable){
        int page = 0;
        if(pageable.getPageNumber() != 0){
            page = pageable.getPageNumber() -1;
            System.out.println("page : " + page);
        }

        pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "boardNo"));

        // board/list?page=1 ==> pageable 에 page 로 들어감
        Page<BoardMasterVO> pageList = boardService.findAll2(pageable);

        //        List<BoardMasterVO> boardList = boardService.findAll();//기본 전체 호출

        mav.setViewName("board/list");
        mav.addObject("boardList", pageList);
        return mav;
    }


    @GetMapping(value = "/insertView")
    public String insertView(){
        return "board/insertView";
    }

    @GetMapping(value = "/{no}")
    public ModelAndView findByBoardId(ModelAndView mav, @PathVariable("no") int no){
        mav.setViewName("board/detail");
        mav.addObject("board", boardService.findByBoardId(no));
//        mav.addObject("page", "");
//        mav.addObject("size", "");
        return mav;
    }

    @PostMapping(value = "/insert")
    public String insertBoard(BoardMasterVO vo){
        boardService.insertBoard(vo);
        return "redirect:/board/list";
    }

    @PostMapping(value = "/update")
    public String updateBoard(BoardMasterVO request){
        request.setBoardCount(request.getBoardCount()-1);
        boardService.updateBoard(request);
        int no = request.getBoardNo();

        return "redirect:/board/"+no;
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ResultSet<String> deleteBoard(BoardMasterVO request){
        ResultSet<String> resultSet = new ResultSet<>();

        Map<String,Object> resultList = new HashMap<>();
        int result = boardService.deleteBoard(request.getBoardNo());

        if(result > 0){
            resultSet.setResponseMessage("success");
        }else{
            resultList.put("boardNo",request.getBoardNo());
            resultSet.setResponseMessage("fail");
        }
        resultList.put("result",result);
        resultSet.setResultList(resultList);
        return resultSet;
    }
}
