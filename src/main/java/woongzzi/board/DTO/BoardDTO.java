package woongzzi.board.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woongzzi.board.domain.entity.BoardEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {

    private Long seq;
    private String title;
    private String content;
    private String id;
    private LocalDateTime regDate;

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .seq(seq)
                .title(title)
                .content(content)
                .id(id)
                .regDate(regDate)
                .build();
    }

    @Builder
    public BoardDTO(Long seq, String title, String content, String id, LocalDateTime regDate) {
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.id = id;
        this.regDate = regDate;
    }
}
