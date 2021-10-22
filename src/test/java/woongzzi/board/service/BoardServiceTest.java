package woongzzi.board.service;

import org.junit.jupiter.api.Test;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.domain.repository.BoardRepository;

import java.util.List;

class BoardServiceTest {

    BoardService boardService;

    @Test
    void findAll() {
        List<BoardDTO> boardDTO = boardService.findMember();
    }



}