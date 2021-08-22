package com.example.groupware.service.board;

import com.example.groupware.entity.board.BoardMasterVO;
import com.example.groupware.repository.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardMasterVO> findAll(){
        return boardRepository.findAll();
    }
    public BoardMasterVO findByBoardId(int id){
        return boardRepository.findByBoardId(id);
    }
    public BoardMasterVO insertBoard(BoardMasterVO vo){
        return boardRepository.saveAndFlush(vo);
    }
    public int updateBoard(BoardMasterVO vo){
//        return boardRepository.updateBoard(vo);
        return 0;
    }
    public int deleteBoard(int id){
//        return boardRepository.deleteBoard(id);
        return 0;
    }
}
