package com.example.groupware.container;


import com.example.groupware.entity.board.BoardMasterVO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

@Component
public class TodoSpecification {

    public static Specification<BoardMasterVO> equalTodoId(Long boardId) {
        return new Specification<BoardMasterVO>() {
            @Override
            public Predicate toPredicate(Root<BoardMasterVO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 1) equal
                return criteriaBuilder.equal(root.get("boardId"), boardId);
                //board_id = ?
            }
        };
    }

    public static Specification<BoardMasterVO> likeContents(String contents) {
        return new Specification<BoardMasterVO>() {
            @Override
            public Predicate toPredicate(Root<BoardMasterVO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 2) like
                return criteriaBuilder.like(root.get("contents"), "%" + contents + "%");
                // content like = ?
            }
        };
    }

    //between Search Term
    public static <T> Specification<T> betweenCreatedDate(LocalDateTime startDatetime, LocalDateTime endDatetime) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 3) between
                return criteriaBuilder.between(root.get("createdDate"), startDatetime, endDatetime);
                // created_date between ? and ?
            }
        };
    }

    //delete YN
    public static <T> Specification<T> equalIsDel(String isDel) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("isDel"), isDel);
                //isDel = ?
            }
        };
    }
}
