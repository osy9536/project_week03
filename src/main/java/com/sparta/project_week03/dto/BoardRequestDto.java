package com.sparta.project_week03.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String title;
    private String userName;
    private String password;
    private String content;


    public BoardRequestDto(String title, String userName,String password, String  content) {
        this.title = title;
        this.userName = userName;
        this.password= password;
        this.content= content;
    }

}