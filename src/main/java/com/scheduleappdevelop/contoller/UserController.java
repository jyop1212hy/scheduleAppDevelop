package com.scheduleappdevelop.contoller;

import com.scheduleappdevelop.dto.*;
import com.scheduleappdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/scheduleUsers")
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping
    public CreateUserResponse createUser(
            @RequestBody CreateUserRequest request) {
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
}
