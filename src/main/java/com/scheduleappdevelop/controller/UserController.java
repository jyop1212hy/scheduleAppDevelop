package com.scheduleappdevelop.controller;

import com.scheduleappdevelop.dto.*;
import com.scheduleappdevelop.entity.User;
import com.scheduleappdevelop.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/scheduleUsers")
public class UserController {

    private final UserService userService;

    //유저 생성 -> 회원가입
    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    //유저 조회
    @GetMapping
    public List<AllUserResponse> getAllUsers() {
            return userService.getAllUsers();
    }

    //유저 단건 조회
    @GetMapping("/{id}")
    public SingleUserResponse getUserById(
            @PathVariable Long id) {
        return userService.getUserById(id);
    }

    //유저 수정
    @PatchMapping("/{id}")
    public UpdateUserResponse updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }

    //유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("선택하신 유저가 삭제 완료되었습니다.");
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> logln( @Valid @RequestBody LoginRequest request, HttpSession session){

        //로그인 검증
        User user = userService.login(request);

        //세션 생성 및 저장
        session.setAttribute("loginUser", user.getId());

        //로그인 성공후 본인 데이터 돌려보내주면서 확인시켜주기
        LoginResponse response = new LoginResponse(
                user.getId(),
                user.getEmail()
        );

        return ResponseEntity.ok(response);
    }


}
