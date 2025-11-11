package com.scheduleappdevelop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @Getter // 캡슐화를 위한 사용
// @NoArgsConstructor // 외부객체를 통해 값을 받는것이 아니기에 해당 롬복을 사용한다.
public class CreateScheduleRequest {
    private String createdUserName;
    private String toDoTitle;
    private String toDoContent;


    public CreateScheduleRequest(String createdUserName, String toDoTitle, String toDoContent) {
        this.createdUserName = createdUserName;
        this.toDoTitle = toDoTitle;
        this.toDoContent = toDoContent;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    public String getToDoTitle() {
        return toDoTitle;
    }

    public String getToDoContent() {
        return toDoContent;
    }
}