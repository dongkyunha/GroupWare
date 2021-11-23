package com.example.groupware.entity.employee;

import com.example.groupware.entity.DomainDateVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee00")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee00VO extends DomainDateVO {

    private static final long serialVersionUID = 1851112599569422513L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_password", nullable = false)
    private String employeePassword;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_sex")
    private String employeeSex;

    @Column(name = "employee_birthDay")
    private String employeeBirthDay;
}
