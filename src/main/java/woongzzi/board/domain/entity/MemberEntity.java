package woongzzi.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name ="member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String sex;

    @Builder
    public MemberEntity(long no, String id, String password, String name, String address, String tel, String sex) {
        this.no = no;
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.sex = sex;
    }
}


