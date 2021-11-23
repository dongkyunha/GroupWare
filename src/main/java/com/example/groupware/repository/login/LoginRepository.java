package com.example.groupware.repository.login;

import com.example.groupware.entity.employee.Employee00VO;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository {

    //insert
    Employee00VO saveAndFlush(Employee00VO vo);
}
