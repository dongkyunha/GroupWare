package com.example.groupware.controller.board;

import com.example.groupware.entity.board.BoardVO;
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
        List<BoardVO> boardList = boardService.findBoardAll();
//        List<BoardVO> boardList = new ArrayList<>();
        mav.setViewName("board/list");
        mav.addObject("boardlist", boardList);
        return mav;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView findByBoardId(ModelAndView mav, @PathVariable("id") String id){
        mav.setViewName("board/detail");
        mav.addObject("board", boardService.findByBoardId(id));
        return mav;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<BoardVO> insertBoard(BoardVO vo){
        return new ResponseEntity<BoardVO>(boardService.insertBoard(vo), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<BoardVO> updateBoard(BoardVO vo){
        boardService.updateBoard(vo);
        return new ResponseEntity<BoardVO>(vo, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("id") String id){
        boardService.deleteBoard(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
