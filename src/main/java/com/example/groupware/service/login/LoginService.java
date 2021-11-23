package com.example.groupware.service.login;

import com.example.groupware.entity.employee.Employee00VO;
import com.example.groupware.repository.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public Employee00VO insertEmployeeInfo(Employee00VO vo){
        return loginRepository.saveAndFlush(vo);
    }
}
