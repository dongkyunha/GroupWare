package com.example.groupware.service.board;

import com.example.groupware.container.TodoSpecification;
import com.example.groupware.entity.board.BoardMasterVO;
import com.example.groupware.entity.board.RequestBoard;
import com.example.groupware.repository.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardMasterVO> findAll(){
        //순서
//        return boardRepository.findAll();
        //역순
        return boardRepository.findAllByOrderByBoardNoDesc();
    }

    public Page<BoardMasterVO> findAll2(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public Page<BoardMasterVO> findAllWhere(RequestBoard request, Pageable pageable){
        Specification<BoardMasterVO> spec = Specification.where(TodoSpecification.equalIsDel("N"));

        if(!request.getSearchContent().equals("")) {
            spec = spec.and(TodoSpecification.likeContents(request.getSearchContent()))
                    .and(TodoSpecification.likeTitles(request.getSearchContent()));
        }

//        if(startDatetime != null && endDatetime != null) {
//            spec = spec.and(TodoSpecification.betweenCreatedDate(startDatetime, endDatetime));
//        }

        return boardRepository.findAll(spec, pageable);
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
//        return boardRepository.saveAndFlush(vo);        //update는 되나 전체 merge 기준이라 count 초기화됨
        return boardRepository.updateBoard(params);
    }
    public int deleteBoard(int id){
        return boardRepository.deleteBoard(id, "Y");
    }
}
