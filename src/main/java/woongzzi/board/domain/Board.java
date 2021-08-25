package woongzzi.board.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 값을 자동으로
    private Long boardNum;
    private String title;
    private String content;
    private String id;
    private Timestamp regDate;

    public Long getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(Long boardNum) {
        this.boardNum = boardNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }
}