package com.example.groupware.repository.board;

import com.example.groupware.entity.board.BoardMasterVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardMasterVO, Integer> {

    public List<BoardMasterVO> findAll();

    public BoardMasterVO getById(@Param("boardNo") int boardNo);

    @Query(value = "SELECT a FROM BoardMasterVO as a WHERE a.boardNo =  :id")
    public BoardMasterVO findByBoardId(@Param("id") int id);

    public BoardMasterVO saveAndFlush(BoardMasterVO vo);
//    public int updateBoard(BoardVO vo);
//    public int deleteBoard(int id);
}



