package woongzzi.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongzzi.board.domain.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
