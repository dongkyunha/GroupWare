package com.example.groupware.repository.board;

import com.example.groupware.entity.board.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository{
//public interface BoardRepository extends JpaRepository {
    public List<BoardVO> findBoardAll();
    public BoardVO findByBoardId(String id);
    public BoardVO insertBoard(BoardVO vo);
    public int updateBoard(BoardVO vo);
    public int deleteBoard(String id);
}


