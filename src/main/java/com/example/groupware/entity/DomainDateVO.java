package com.example.groupware.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@MappedSuperclass
public class DomainDateVO implements Serializable {

    @Column(name = "created_date")
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate = LocalDateTime.now();
}
