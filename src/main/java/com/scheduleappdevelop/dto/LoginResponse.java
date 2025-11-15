package com.scheduleappdevelop.dto;

public class LoginResponse {
    private final Long userId;
    private final String email;

    public LoginResponse(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    //Getter
    public Long getUserId() { return userId; }
    public String getEmail() { return email; }
}
