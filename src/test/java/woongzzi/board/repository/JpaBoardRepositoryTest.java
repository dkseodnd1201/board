package woongzzi.board.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import woongzzi.board.domain.Board;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpaBoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

//    @Test
//    void save() {
//        Board params = Board.builder()
//                .title("1번 게시글 제목")
//                .content("1번 게시글 내용")
//                .id("도뎡이")
//                .regDate();
//
//        boardRepository.save(params);
//        Board entity = boardRepository.findById((long) 1).get();
//        assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
//        assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
//        assertThat(entity.getWriter()).isEqualTo("도뎡이");
//    }

}