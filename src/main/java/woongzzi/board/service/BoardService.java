package woongzzi.board.service;

import org.springframework.stereotype.Service;
import woongzzi.board.repository.BoardRepository;

@Service
public class BoardService {

    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

}
