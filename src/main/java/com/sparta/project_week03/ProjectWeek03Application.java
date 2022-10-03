package com.sparta.project_week03;
import com.sparta.project_week03.domain.Board;
import com.sparta.project_week03.repository.BoardRepository;
import com.sparta.project_week03.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectWeek03Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWeek03Application.class, args);

	}

	@Bean
	public CommandLineRunner demo(BoardRepository BoardRepository, BoardService BoardService) {
		return (args) -> {
			BoardRepository.save(new Board("프론트엔드의 꽃, 리액트", "임민영","123456","안녕하세요"));

			System.out.println("데이터 인쇄");
			List<Board> BoardList = BoardRepository.findAll();
			for (int i=0; i<BoardList.size(); i++) {
				Board Board = BoardList.get(i);
				System.out.println(Board.getId());
				System.out.println(Board.getTitle());
				System.out.println(Board.getuserName());
				System.out.println(Board.getpassword());
				System.out.println(Board.getcontent());


			}
			Board requestDto = new Board("웹개발의 봄, Spring", "임민영","456123","오랜만입니다.");
			BoardService.update(1L, requestDto);
			BoardList = BoardRepository.findAll();
			for (int i=0; i<BoardList.size(); i++) {
				Board Board = BoardList.get(i);
				System.out.println(Board.getId());
				System.out.println(Board.getTitle());
				System.out.println(Board.getuserName());
				System.out.println(Board.getpassword());
				System.out.println(Board.getcontent());


			}

		};
	}



}
