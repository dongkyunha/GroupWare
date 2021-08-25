package com.example.groupware.controller.board;

import com.example.groupware.entity.board.BoardMasterVO;
import com.example.groupware.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/list")
    public ModelAndView findBoardAll(ModelAndView mav){
        List<BoardMasterVO> boardList = boardService.findAll();
        System.out.println("테스트");
        mav.setViewName("board/list");
        mav.addObject("boardList", boardList);
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
