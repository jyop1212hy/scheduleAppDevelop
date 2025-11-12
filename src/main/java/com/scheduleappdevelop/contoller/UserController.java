package com.scheduleappdevelop.contoller;

import com.scheduleappdevelop.dto.CreateUserRequest;
import com.scheduleappdevelop.dto.CreateUserResponse;
import com.scheduleappdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/scheduleUser")
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest userData){
        return userService.createUser(userData);
    }

    //유저 조회
    //유저 수정
    //유저 삭제
}
