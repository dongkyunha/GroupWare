package com.example.groupware.repository.test;

import com.example.groupware.entity.board.BoardMasterVO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class testRepository {

//    public SessionFactory sessionFactory;
//
//    public Session session = sessionFactory.getCurrentSession();
//
//    public List<Map<String,Object>> selectName(BoardMasterVO t){
//        StringBuffer str = new StringBuffer();
//        str.append("SELECT BOARD_TITLE ");
//        str.append("FROM BOARD_MASTER ");
//
//        Query query = (Query) session.createQuery(str.toString()).getParameter(t.getBoardTitle());
//
//        List<Map<String,Object>> result = query.list();
//        return result;
//    }
}
