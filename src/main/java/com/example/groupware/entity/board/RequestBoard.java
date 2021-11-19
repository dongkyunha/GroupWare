package com.example.groupware.entity.board;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RequestBoard{

    private String SearchType = "";

    private String SearchContent = "";

    private String SearchId = "";

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;
}
