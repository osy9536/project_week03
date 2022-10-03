package com.sparta.project_week03.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardPWRequestDto {
    private String password;


    public BoardPWRequestDto(String password) {
        this.password= password;
    }

}
