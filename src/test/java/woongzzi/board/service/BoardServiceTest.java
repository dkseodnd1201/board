package woongzzi.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.domain.entity.BoardEntity;
import woongzzi.board.domain.repository.BoardRepository;

import java.time.LocalDateTime;
import java.util.List;

class BoardServiceTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void getBoard() {

        //given
        int seq = 1;
        String title = "test_title";
        String content = "test_content";
        String id = "test_id";
        LocalDateTime createdDate = LocalDateTime.now();
        LocalDateTime modifiedDate = LocalDateTime.now();

//        boardRepository.save(BoardDTO.builder()
//                .seq(seq)
//                .title(title)
//                .content(content)
//                .id(id)
//                .createdDate(createdDate)
//                .modifiedDate(modifiedDate)
//                .build());

        //when
        List<BoardEntity> boardEntities = boardRepository.findAll();
        //then
        BoardEntity boardEntity = boardEntities.get(0);
    }
}