package com.sparta.project_week03.service;

import com.sparta.project_week03.domain.Board;
import com.sparta.project_week03.repository.BoardRepository;
import com.sparta.project_week03.dto.BoardRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BoardService {
//spring boot ioc di
    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final BoardRepository BoardRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    public BoardService(BoardRepository BoardRepository) {
        this.BoardRepository = BoardRepository;
    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, Board requestDto) {
        Board Board1 = BoardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        Board1.update(requestDto);
        return Board1.getId();
    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, BoardRequestDto requestDto) {//put
        Board Board1 = BoardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        Board1.update(requestDto);
        return Board1.getId();
    }

}