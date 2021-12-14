package com.example.groupware.repository.test;

import com.example.groupware.entity.board.BoardMasterVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class testRepository {

    public SessionFactory sessionFactory;

    public Session session = sessionFactory.getCurrentSession();
    
    public BoardMasterVO selectName(BoardMasterVO t){
        StringBuffer str = new StringBuffer();
        str.append("SELECT BOARD_TITLE ");
        str.append("FROM BOARD_MASTER ");

        session.createQuery(str.toString()).getParameter(t.getBoardTitle());

        return t;
    }


}
