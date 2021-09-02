package woongzzi.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woongzzi.board.domain.Board;
import woongzzi.board.domain.BoardDTO;
import woongzzi.board.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public List<BoardDTO> findAll() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for(Board board : boardList) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .seq(board.getSeq())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .id(board.getId())
                    .regDate(board.getRegDate())
                    .build();
            boardDTOList.add(boardDTO);
        }

        return boardDTOList;
    }
}
