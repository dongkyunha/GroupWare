package com.example.groupware.entity.board;

import com.example.groupware.entity.DomainDateVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "board_master")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@DynamicInsert
//@DynamicUpdate
public class BoardMasterVO extends DomainDateVO {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private int boardNo;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_type")
    private String boardType;

    @Column(name = "board_content", length = 500)
    private String boardContent;

    @Column(name = "board_id")
    private String boardId;

    @Column(name = "board_password")
    private String boardPassword;

    @Column(name = "board_count", nullable = false, columnDefinition = "int default 0")
    private int boardCount;

    @Column(name = "is_del", columnDefinition = "varchar(1) default 'N'")
    private String isDel;
}
