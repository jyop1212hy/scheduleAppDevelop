package com.scheduleappdevelop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "이메일은 필수입니다.") // 데이터가 비어있으면 안된다!
    @Email(message = "올바른 이메일 형식이 아닙니다.") // 이메일 형식에 맞춰있어야 한다.
    private final String email;

    @NotBlank(message = "비밀번호는 필수입니다.") // 데이터가 비어있으면 안된다.
    private final String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //Getter
    public String getEmail() { return email; }
    public String getPassword() { return password; }

}
