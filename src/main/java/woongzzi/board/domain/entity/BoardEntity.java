package woongzzi.board.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name ="board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 값을 자동으로
    private int seq;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String content;

    @Column(nullable = true)
    private String id;

    @Column(nullable = true)
    private Date regDate;

    @Column(nullable = true)
    private Date upDate;

    @Builder
    public BoardEntity(int seq, String title, String content, String id, Date regDate, Date upDate) {
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.id = id;
        this.regDate = regDate;
        this.upDate = upDate;
    }
}