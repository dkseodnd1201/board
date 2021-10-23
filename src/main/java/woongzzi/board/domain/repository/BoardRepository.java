package woongzzi.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongzzi.board.domain.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

}
