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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/list")
    public ModelAndView findBoardAll(ModelAndView mav, @PageableDefault Pageable pageable){
        List<BoardMasterVO> boardList = boardService.findAll();
//        System.out.println("테스트");
        pageable = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "boardNo"));

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
        boardService.updateBoard(request);
        int no = request.getBoardNo();
//        return new ResponseEntity<BoardMasterVO>(request, HttpStatus.OK);
        return "redirect:/board/"+no;
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("BoardMasterVO") BoardMasterVO request){
        boardService.deleteBoard(request.getBoardNo());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
