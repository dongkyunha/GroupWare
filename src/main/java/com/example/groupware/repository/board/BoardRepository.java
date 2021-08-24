package com.example.groupware.repository.board;

import com.example.groupware.entity.board.BoardMasterVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardMasterVO, Integer> {

    //selectAll
    List<BoardMasterVO> findAll();

    //select
    @Query("SELECT BM FROM BoardMasterVO as BM WHERE BM.boardNo = :id")
    BoardMasterVO findByBoardId(@Param("id") int id);
//    BoardMasterVO getById(@Param("boardNo") int boardNo);  //JpaRepository 제공

    //insert
    BoardMasterVO saveAndFlush(BoardMasterVO vo);

    //updateCount
    @Transactional
    @Modifying
    @Query("UPDATE BoardMasterVO SET boardCount = :count WHERE boardNo = :id")
    int updateBoardId(@Param("id") int id, @Param("count") int count);

//    @Query("UPDATE BoardMasterVO AS BM SET BM.boardTitle = :title WHERE BM.boardNo = :id")
//    int updateBoard(BoardMasterVO vo);

    //delete
//    public int deleteBoard(int id);
}



