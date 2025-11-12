package com.scheduleappdevelop.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //상속한 엔터티들이 속성값(필드)를 컬럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class) //상속받은 엔터티가 데이터를 생성 할때마다 생성 or 수정 시간을 체크해줌
//엔터티 수량 증가시 확장성 고려한 시간 통합 엔터티
public class BaseTimeEntity {

    //일정 생성 시간
    @CreatedDate // 생성날짜,시간시간
    private LocalDateTime createdAt;

    //일정 수정 시간
    @LastModifiedDate //수정날짜,시간
    private LocalDateTime modifiedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}
