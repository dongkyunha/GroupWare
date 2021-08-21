package com.example.groupware.service.board;

import com.example.groupware.entity.board.BoardVO;
import com.example.groupware.repository.board.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public List<BoardVO> findBoardAll(){
        return boardRepository.findBoardAll();
//        return null;
    }
    public BoardVO findByBoardId(String id){
//        return boardRepository.findByBoardId(id);
        return null;
    }
    public BoardVO insertBoard(BoardVO vo){
//        return boardRepository.insertBoard(vo);
        return null;
    }
    public int updateBoard(BoardVO vo){
//        return boardRepository.updateBoard(vo);
        return 0;
    }
    public int deleteBoard(String id){
//        return boardRepository.deleteBoard(id);
        return 0;
    }
}
