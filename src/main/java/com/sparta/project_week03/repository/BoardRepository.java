package com.sparta.project_week03.repository;
import com.sparta.project_week03.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<BoardMapping> findAllByOrderByCreatedAtDesc();
    List<BoardMappingFour> findAllByOrderByModifiedAtDesc();
    Optional<Board> findByPassword(String password);
}

