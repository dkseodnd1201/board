package woongzzi.board.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import woongzzi.board.domain.Board;
import woongzzi.board.repository.BoardRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    BoardRepository boardRepository;

    @Test
    public void findAll() {
        List<Board> result = boardRepository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(1);
    }
}