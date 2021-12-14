package com.example.groupware.repository.test;

import com.example.groupware.entity.board.BoardMasterVO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class testRepository {

    @PersistenceContext
    EntityManager entityManager;
    
    Session session = entityManager.unwrap(Session.class);

//    public SessionFactory sessionFactory;
//    Session session = sessionFactory.getCurrentSession();
//
    public List<Map<String,Object>> selectName(BoardMasterVO t){
        StringBuffer str = new StringBuffer();
        str.append("SELECT BOARD_TITLE ");
        str.append("FROM BOARD_MASTER ");

        Query query = (Query) session.createQuery(str.toString()).getParameter(t.getBoardTitle());

        List<Map<String,Object>> result = query.getResultList();
        return result;
    }
}
