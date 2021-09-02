package com.example.groupware.controller.board;

import com.example.groupware.entity.board.BoardMasterVO;
import com.example.groupware.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/list")
    public ModelAndView findBoardWhereAll(ModelAndView mav,@PageableDefault Pageable pageable){
        int page = 0;
        if(pageable.getPageNumber() != 0){
            page = pageable.getPageNumber() -1;
            System.out.println("page : " + page);
        }
        pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "boardNo"));

        Page<BoardMasterVO> pageList = boardService.findAllWhere(pageable);

        mav.setViewName("board/list");
        mav.addObject("boardList", pageList);
        return mav;
    }

    //clean code
    @GetMapping(value = "/list2")
//    @RequestMapping(value ="/list", method = RequestMethod.GET)
    public ModelAndView findBoardAll(ModelAndView mav, @PageableDefault Pageable pageable){
        int page = 0;
        if(pageable.getPageNumber() != 0){
            page = pageable.getPageNumber() -1;
            System.out.println("page : " + page);
        }

//        List<BoardMasterVO> boardList = boardService.findAll();//기본 전체 호출

        pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "boardNo"));

        // board/list?page=1 ==> pageable 에 page 로 들어감
        Page<BoardMasterVO> pageList = boardService.findAll2(pageable);

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
    public String deleteBoard(BoardMasterVO request){
        int result = boardService.deleteBoard(request.getBoardNo());

        if(result > 0){
            //todo true
            return "redirect:/board/list";
        }else{
            System.out.println("저장에 문제 있음");
            int no = request.getBoardNo();
            return "redirect:/board/"+no;
        }
    }
}
