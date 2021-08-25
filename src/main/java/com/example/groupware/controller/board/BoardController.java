package com.example.groupware.controller.board;

import com.example.groupware.entity.board.BoardMasterVO;
import com.example.groupware.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/{id}")
    public ModelAndView findByBoardId(ModelAndView mav, @PathVariable("id") int id){
        mav.setViewName("board/detail");
        mav.addObject("board", boardService.findByBoardId(id));
        return mav;
    }

    @PostMapping(value = "/insert")
    public String insertBoard(BoardMasterVO vo){
        boardService.insertBoard(vo);
        return "redirect:/board/list";
    }

    @PostMapping(value = "/update")
    public ResponseEntity<BoardMasterVO> updateBoard(BoardMasterVO vo){
        boardService.updateBoard(vo);
        return new ResponseEntity<BoardMasterVO>(vo, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("BoardMasterVO") BoardMasterVO request){
        boardService.deleteBoard(request.getBoardNo());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
