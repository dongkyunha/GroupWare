package com.example.groupware.container;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FileInfo {
    private String basePath = "D:\\downloads\\groupware";	//파일 기본경로
    private String filePath;		//추가 파일경로
    private String fileName;		//파일이름
    private String fileMediaType;   //파일타입
    private long fileSize;          //파일크기
}
