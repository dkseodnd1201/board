package woongzzi.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.domain.entity.BoardEntity;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

}
