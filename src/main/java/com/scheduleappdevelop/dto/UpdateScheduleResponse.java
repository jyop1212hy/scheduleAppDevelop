package com.scheduleappdevelop.dto;

import java.time.LocalDateTime;

public class UpdateScheduleResponse {
    private final Long id;
    private final String toDoTitle;
    private final String toDoContent;
//    private final String createdUserName;
    private final Long userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

//    public UpdateScheduleResponse(Long id, String toDoTitle, String toDoContent, String createdUserName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
//        this.id = id;
//        this.toDoTitle = toDoTitle;
//        this.toDoContent = toDoContent;
//        this.createdUserName = createdUserName;
//        this.createdAt = createdAt;
//        this.modifiedAt = modifiedAt;
//    }


    public UpdateScheduleResponse(Long id, String toDoTitle, String toDoContent, Long userId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.toDoTitle = toDoTitle;
        this.toDoContent = toDoContent;
        this.userId = userId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getId() {
        return id;
    }
    public String getToDoTitle() {
        return toDoTitle;
    }
    public String getToDoContent() {
        return toDoContent;
    }
//    public String getCreatedUserName() { return createdUserName; }
    public Long getUserId() {return userId; }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

}
