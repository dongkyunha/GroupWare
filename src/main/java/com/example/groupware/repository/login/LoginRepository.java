package com.example.groupware.repository.login;

import com.example.groupware.entity.employee.Employee00VO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Employee00VO, Integer>, JpaSpecificationExecutor<Employee00VO> {

    //insert
    Employee00VO saveAndFlush(Employee00VO vo);
}
