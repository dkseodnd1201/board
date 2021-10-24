package woongzzi.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.domain.entity.BoardEntity;
import woongzzi.board.domain.repository.BoardRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BoardService {
    final private BoardRepository boardRepository;

    @Transactional
    public List<BoardDTO> getBoardlist() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDTO> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDTO boardDTO1 = BoardDTO.builder()
                    .seq(boardEntity.getSeq())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .id(boardEntity.getId())
                    .createdDate(boardEntity.getCreatedDate())
                    .modifiedDate(boardEntity.getModifiedDate())
                    .build();
            boardDtoList.add(boardDTO1);
        }
        return boardDtoList;
    }

    @Transactional
    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO.toEntity());
    }

    @Transactional
    public BoardDTO getPost(long seq) {
        Optional<BoardEntity> boardEntities = boardRepository.findById(seq);
        BoardEntity boardEntity = boardEntities.get();
        BoardDTO boardDTO = BoardDTO.builder()
                .seq(boardEntity.getSeq())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .id(boardEntity.getId())
                .createdDate(boardEntity.getCreatedDate())
                .modifiedDate(boardEntity.getModifiedDate())
                .build();
        return boardDTO;
    }
}
