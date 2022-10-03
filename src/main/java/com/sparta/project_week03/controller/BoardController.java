package com.sparta.project_week03.controller;

import com.sparta.project_week03.domain.Board;
import com.sparta.project_week03.repository.BoardMapping;
import com.sparta.project_week03.repository.BoardMappingFour;
import com.sparta.project_week03.repository.BoardRepository;
import com.sparta.project_week03.dto.BoardRequestDto;
import com.sparta.project_week03.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository BoardRepository;
    private final BoardService BoardService;


    @GetMapping("/api/Board") //2번 제목, 작성자명,날짜 내림차순으로 정렬및 조회
    public List<BoardMapping> getBoard() {
        return BoardRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/Board/Four") //2번 제목, 작성자명,날짜 내림차순으로 정렬및 조회
    public List<BoardMappingFour> getBoardFour() {
        return BoardRepository.findAllByOrderByModifiedAtDesc();
    }



    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/Board") //2번 요구사항
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Board이니, Dto의 정보를 Board에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Board Board = new Board(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return BoardRepository.save(Board);
    }
    @PostMapping("/api/Board/{id}") //5번 요구사항
    public Optional<Board> findPassword(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return BoardRepository.findByPassword(String.valueOf(requestDto));
    }

    @PutMapping("/api/Board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody Board requestDto) {

        return BoardService.update(id, requestDto);
    }

    @DeleteMapping("/api/Board/{id}")
    public Long deletePerson(@PathVariable Long id) {
        BoardRepository.deleteById(id);
        return id;
    }


}