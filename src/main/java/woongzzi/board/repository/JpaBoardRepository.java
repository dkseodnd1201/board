package woongzzi.board.repository;

import woongzzi.board.domain.Board;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        return null;
    }

    @Override
    public Optional<Board> findById(Long seq) {
        return Optional.empty();
    }

    @Override
    public List<Board> findAll() {
        return null;
    }

    @Override
    public void Delete(Board board) {

    }
}
