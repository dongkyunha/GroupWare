package com.example.groupware.repository.board;

import com.example.groupware.entity.board.BoardMasterVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    //selectAll(역순)
    List<BoardMasterVO> findAllByOrderByBoardNoDesc();

    //selectAll pageable
    @Override
    Page<BoardMasterVO> findAll(Pageable pageable);

    //select
    @Query("SELECT BM FROM BoardMasterVO as BM WHERE BM.boardNo = :id")
    BoardMasterVO findByBoardId(@Param("id") int id);

//    BoardMasterVO getById(@Param("boardNo") int boardNo);  //JpaRepository 제공
//    BoardMasterVO findById(@Param("boardNo") int boardNo);  //JpaRepository 제공

    //insert
    BoardMasterVO saveAndFlush(BoardMasterVO vo);

    //updateCount
    @Transactional
    @Modifying
    @Query(value="UPDATE BoardMasterVO SET boardCount = :count WHERE boardNo = :id")
    int updateBoardId(@Param("id") int id, @Param("count") int count);

    //updateDetail
    @Transactional
    @Modifying
    @Query("UPDATE BoardMasterVO SET boardType = :#{#params.boardType}, boardTitle = :#{#params.boardTitle}, boardContent = :#{#params.boardContent}, boardId = :#{#params.boardId}, boardCount = :#{#params.boardCount}, modifiedDate =:#{#params.modifiedDate} WHERE boardNo = :#{#params.boardNo}")
    int updateBoard(@Param("params") BoardMasterVO params);

    //delete
    @Transactional
    @Modifying
    @Query(value="UPDATE BoardMasterVO SET isDel = :isDel WHERE boardNo = :id")
    int deleteBoard(int id, String isDel);
}



