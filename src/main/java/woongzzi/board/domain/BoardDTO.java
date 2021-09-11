package woongzzi.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public Board toEntity() {
        return Board.builder()
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
