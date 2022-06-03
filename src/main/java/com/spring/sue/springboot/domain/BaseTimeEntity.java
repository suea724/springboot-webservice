package com.spring.sue.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 하위 클래스가 BaseTimeEntity의 필드들을 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate // Entity 생성 시 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // Entity 수정 시 시간 자동 저장
    private LocalDateTime modifiedDate;
}
