package woongzzi.board.DTO;

import lombok.*;
import woongzzi.board.domain.entity.MemberEntity;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDTO {
    private long no;
    private String id;
    private String password;
    private String name;
    private String address;
    private String tel;
    private String sex;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .no(no)
                .id(id)
                .password(password)
                .name(name)
                .address(address)
                .tel(tel)
                .sex(sex)
                .build();
    }

    @Builder
    public MemberDTO(long no, String id, String password, String name, String address, String tel, String sex) {
        this.no = no;
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.sex = sex;
    }
}
