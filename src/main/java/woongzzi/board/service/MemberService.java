package woongzzi.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import woongzzi.board.domain.repository.MemberRepository;

@AllArgsConstructor
@Service
public class MemberService {
    final private MemberRepository memberRepository;

}
