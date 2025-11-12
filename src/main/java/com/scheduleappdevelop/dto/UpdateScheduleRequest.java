package com.scheduleappdevelop.dto;

public class UpdateScheduleRequest {
    private final String toDoTitle;
    private final String toDoContent;
    private final String createdUserName;

    public UpdateScheduleRequest(String toDoTitle, String toDoContent, String createdUserName) {
        this.toDoTitle = toDoTitle;
        this.toDoContent = toDoContent;
        this.createdUserName = createdUserName;
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

}
