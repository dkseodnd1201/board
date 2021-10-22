package woongzzi.board.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name ="board")
public class BoardEntity extends TimeEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String content;

    @Column(nullable = true)
    private String id;

    @Builder
    public BoardEntity(int seq, String title, String content, String id) {
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.id = id;
    }
}