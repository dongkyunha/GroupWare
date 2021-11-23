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

    // 1) equal
    public static Specification<BoardMasterVO> equalTodoId(Long boardId) {
        return new Specification<BoardMasterVO>() {
            @Override
            public Predicate toPredicate(Root<BoardMasterVO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("boardId"), boardId);
                //board_id = ?
            }
        };
    }

    // 2) like - stream
    public static Specification<BoardMasterVO> likeContents(String contents) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("boardContent"), "%" + contents + "%");
            // board_content like "?"
        };
    }
    public static Specification<BoardMasterVO> likeTitles(String contents) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("boardTitle"), "%" + contents + "%");
            // board_title like "?"
        };
    }
    public static Specification<BoardMasterVO> likeboardIds(String contents) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("boardId"), "%" + contents + "%");
            // board_title like "?"
        };
    }

    // 2) like
    public static <T> Specification<T> likeEmpName(String empName) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("empName"), "%" + empName + "%");
                //employee_name like "?"
            }
        };
    }

    //3) between Search Term
    public static <T> Specification<T> betweenCreatedDate(LocalDateTime startDatetime, LocalDateTime endDatetime) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get("createdDate"), startDatetime, endDatetime);
                // created_date between ? and ?
            }
        };
    }

    //4) delete YN
    public static <T> Specification<T> equalIsDel(String isDel) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 1) equal
                return criteriaBuilder.equal(root.get("isDel"), isDel);
                //is_del = ?
            }
        };
    }
}
