package woongzzi.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.domain.entity.BoardEntity;
import woongzzi.board.domain.repository.BoardRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public List<BoardDTO> getBoardlist() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDTO> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDTO boardDTO1 = BoardDTO.builder()
                    .id(boardEntity.getId())
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



}
