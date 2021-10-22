package woongzzi.board.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //자식클래스에게 매핑정보 상속
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeEntitiy {
    @CreatedDate //Entity가 생성될떄 생성일을 주입하는 어노테이션
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate//Entity가 수정될떄 수정일을 주입하는 어노테이션
    private LocalDateTime modifiedDate;

}