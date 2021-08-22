package com.example.groupware.entity.board;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board_master")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class BoardMasterVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private int boardNo;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_type")
    private String boardType;

    @Column(name = "board_content")
    private String boardContent;

    @Column(name = "board_id")
    private String boardId;

    @Column(name = "board_password")
    private String boardPassword;

    @Column(name = "board_count")
    private int boardCount;

    @Column(name = "create_date")
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate = LocalDateTime.now();


}
