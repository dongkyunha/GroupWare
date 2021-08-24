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

    @Query("SELECT BM FROM BoardMasterVO as BM WHERE BM.boardNo = :id")
    public BoardMasterVO findByBoardId(@Param("id") int id);

    public BoardMasterVO saveAndFlush(BoardMasterVO vo);

//    @Query("UPDATE BoardMasterVO AS BM SET BM.boardTitle = :title WHERE BM.boardNo = :id")
//    public int updateBoard(BoardMasterVO vo);

//    public int deleteBoard(int id);
}



