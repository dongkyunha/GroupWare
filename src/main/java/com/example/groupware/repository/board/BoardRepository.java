package com.example.groupware.repository.board;

import com.example.groupware.entity.board.BoardMasterVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardMasterVO, Integer> {

    public List<BoardMasterVO> findAll();

    @Query("SELECT boardNo, boardTitle FROM BoardMasterVO WHERE boardNo = :id")
    public BoardMasterVO findByBoardId(int id);

//    public BoardMasterVO insertBoard(BoardVO vo);
//    public int updateBoard(BoardVO vo);
//    public int deleteBoard(int id);
}



