package com.example.groupware.entity.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RequestBoard{

    private String searchType = "";

    private String searchContent = "";

    private String searchId = "";

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;
}
