package com.sparta.project_week03.domain;

import com.sparta.project_week03.dto.BoardPWRequestDto;
import com.sparta.project_week03.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
@Getter
public class Board extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;
    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;





    public Board(String title, String userName,String password,String content) {
        this.title = title;
        this.userName = userName;
        this.password = password;
        this.content = content;
    }
    public Board(BoardRequestDto requestDto) { // 3번 제목, 작성자명, 비밀번호, 작성 내용 입력
        this.title = requestDto.getTitle();
        this.userName = requestDto.getUserName();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }
    public Board(BoardPWRequestDto requestDto) { // 3번 제목, 작성자명, 비밀번호, 작성 내용 입력
        this.password = requestDto.getPassword();
    }

    public LocalDateTime createAt(){
        return getCreatedAt();
    }
    public LocalDateTime modifiedAt(){
        return getModifiedAt();
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getuserName() {
        return this.userName;
    }

    public String getpassword() {
        return this.password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getcontent() {
        return this.content;
    }

    public void update(Board requestDto) {
        this.title = requestDto.getTitle();
        this.userName = requestDto.getuserName();
        this.password=requestDto.getpassword();
        this.content=requestDto.getcontent();
    }
    public void update(BoardRequestDto requestDto) {//put
        this.title = requestDto.getTitle();
        this.userName = requestDto.getUserName();
        this.password=requestDto.getPassword();
        this.content=requestDto.getContent();
    }
}

