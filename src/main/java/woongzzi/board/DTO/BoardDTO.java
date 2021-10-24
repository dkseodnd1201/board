package woongzzi.board.DTO;

import lombok.*;
import woongzzi.board.domain.entity.BoardEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {

    private long seq;
    private String title;
    private String content;
    private String id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .seq(seq)
                .title(title)
                .content(content)
                .id(id)
                .build();
    }

    @Builder
    public BoardDTO(long seq, String title, String content, String id, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
