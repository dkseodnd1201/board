package woongzzi.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongzzi.board.domain.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findById(String userId);
}
