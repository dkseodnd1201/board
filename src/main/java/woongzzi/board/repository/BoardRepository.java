package woongzzi.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongzzi.board.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long>{
    Board save(Board board);

}


//    게시물 작성 - 데이터 추가
//        게시물 수정 - 데이터 갱신
//        게시물 삭제 - 데이터 삭제
//        게시물 목록보기 - 데이터 조회