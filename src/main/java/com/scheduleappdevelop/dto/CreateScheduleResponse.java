package com.scheduleappdevelop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// @Getter // 캡슐화를 위한 사용
// @NoArgsConstructor //인자값이 없는 기본 생성자를 만들어줌
// @AllArgsConstructor //클라이언트에게 전달 할 데이터이기에 초기값 있어야 하며 다른 필스에서도 사용 하기 위함
public class CreateScheduleResponse {
    private final Long id;
    private final String toDoTitle;
    private final String toDoContent;
    private final Long userId;
//    private final String createdUserName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

//    public CreateScheduleResponse(Long id, String toDoTitle, String toDoContent, String createdUserName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
//        this.id = id;
//        this.toDoTitle = toDoTitle;
//        this.toDoContent = toDoContent;
//        this.createdUserName = createdUserName;
//        this.createdAt = createdAt;
//        this.modifiedAt = modifiedAt;
//    }

    public CreateScheduleResponse(Long id, String toDoTitle, String toDoContent, Long userId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.toDoTitle = toDoTitle;
        this.toDoContent = toDoContent;
        this.userId = userId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getId() { return id; }
    public String getToDoTitle() { return toDoTitle; }
    public String getToDoContent() { return toDoContent; }
//    public String getCreatedUserName() { return createdUserName; }
    public Long getUserId() { return userId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getModifiedAt() { return modifiedAt; }
}