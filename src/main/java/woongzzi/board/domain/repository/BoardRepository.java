package woongzzi.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import woongzzi.board.domain.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

}
