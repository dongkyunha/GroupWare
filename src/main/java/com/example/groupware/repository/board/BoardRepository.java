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
    @Query(value="UPDATE BoardMasterVO SET boardCount = :count WHERE boardNo = :id")
    int updateBoardId(@Param("id") int id, @Param("count") int count);

//    @Modifying
//    @Query("UPDATE BoardMasterVO SET boardType = :boardType, boardTitle = :boardTitle, boardContent = :boardContent, boardId = :boardId WHERE boardNo = :id")
//    @Query(value = "UPDATE board_master SET board_type = :boardType, board_title = :boardTitle, boardContent = :boardContent, board_id = :boardId WHERE board_no = :boardNo", nativeQuery = true)
//    int updateBoard(@Param("BoardMasterVO") BoardMasterVO vo);

    //delete
//    public int deleteBoard(int id);
}



