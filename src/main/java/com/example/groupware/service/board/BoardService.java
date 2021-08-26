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
//        return boardRepository.findAll();
        //역순
        return boardRepository.findAllByOrderByBoardNoDesc();
    }

    public BoardMasterVO findByBoardId(int id){
        BoardMasterVO resultData = boardRepository.findByBoardId(id);

        int count = resultData.getBoardCount() + 1;
        int result = boardRepository.updateBoardId(id, count);

        if(result >0){
            resultData.setBoardCount(count);
        }
        return resultData;
    }

    public BoardMasterVO insertBoard(BoardMasterVO vo){
        return boardRepository.saveAndFlush(vo);
    }

    public int updateBoard(BoardMasterVO params){
//        System.out.println(params);
//        return boardRepository.saveAndFlush(vo);        //update는 되나 전체 merge 기준이라 count 초기화됨
        return boardRepository.updateBoard(params);
    }
    public int deleteBoard(int id){
        return boardRepository.deleteBoard(id, "Y");
//        return 0;
    }
}
