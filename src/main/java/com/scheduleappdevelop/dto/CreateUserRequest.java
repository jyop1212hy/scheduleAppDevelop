package com.scheduleappdevelop.dto;

public class CreateUserRequest {
    private String name;
    private String email;
    private String password;

    public CreateUserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //Getter
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
