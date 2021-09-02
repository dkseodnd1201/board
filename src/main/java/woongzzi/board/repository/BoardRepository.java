package woongzzi.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongzzi.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board,Long>{
}
