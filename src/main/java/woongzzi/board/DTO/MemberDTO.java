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

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .no(no)
                .id(id)
                .password(password)
                .name(name)
                .address(address)
                .build();
    }

    @Builder
    public MemberDTO(long no, String id, String password, String name, String address) {
        this.no = no;
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
    }
}
