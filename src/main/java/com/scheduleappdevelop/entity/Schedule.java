package com.scheduleappdevelop.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity // JAP엔터티 지정
@Table(name = "schedules") // 테이블 이름 지정
public class Schedule extends BaseTimeEntity {


    @Id //기본 키값(PK)-주민등록번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 값을 DB가 자동으로 만듬
    private Long id;

    //작성자명
    @Column(length = 20, nullable = false) //작성자명 글자수는 20자, 작성자명 칼럼에 값이 없으면 안됨
    private String createdUserName;

    //일정제목
    @Column(length = 100, nullable = false) //제목의 글자수는 50자, 제목칼럼에 값이 없으면 안됨
    private String toDoTitle;

    //일정내용
    @Column(columnDefinition = "TEXT", nullable = false) //일정 내용의 타입은 "TEXT" 타입(클자수가 많음), 제목칼럼에 값이 없으면 안됨
    private String toDoContent;

//    //일정 생성 시간
//    @CreatedDate // 생성날짜,시간
//    @Column(updatable = false) // 생성시간 값이 없으면 안됨
//    private LocalDateTime createdAt;
//
//    //일정 수정 시간
//    @LastModifiedDate //수정시간
//    @Column(nullable = true) // 컬럼을 안써도 되지만 명시적으로 표현하기 위해 작성함
//    private LocalDateTime modifiedAt;

    // 기본 생성자 (JPA용)
    protected Schedule() {
    }

    public Schedule(String toDoTitle, String toDoContent, String createdUserName) {
        this.toDoTitle = toDoTitle;
        this.toDoContent = toDoContent;
        this.createdUserName = createdUserName;
    }


    //getter
    public Long getId() {
        return id;
    }

    public String getToDoTitle() {
        return toDoTitle;
    }

    public String getToDoContent() {
        return toDoContent;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    //setter
    public void setToDoTitle(String toDoTitle) {
        this.toDoTitle = toDoTitle;
    }

    public void setToDoContent(String toDoContent) {
        this.toDoContent = toDoContent;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }
}
