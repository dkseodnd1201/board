package woongzzi.board.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 값을 자동으로
    private Long seq;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private LocalDateTime regDate;

    @Builder
    public BoardEntity(Long seq, String title, String content, String id, LocalDateTime regDate) {
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.id = id;
        this.regDate = regDate;
    }
}