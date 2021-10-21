package woongzzi.board.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woongzzi.board.domain.entity.BoardEntity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {

    private int seq;
    private String title;
    private String content;
    private String id;
    private Date regDate;
    private Date upDate;

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .seq(seq)
                .title(title)
                .content(content)
                .id(id)
                .regDate(regDate)
                .upDate(upDate)
                .build();
    }

    @Builder
    public BoardDTO(int seq, String title, String content, String id, Date regDate, Date upDate) {
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.id = id;
        this.regDate = regDate;
        this.upDate = upDate;
    }
}
