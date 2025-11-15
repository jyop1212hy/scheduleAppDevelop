package com.scheduleappdevelop.controller;

import com.scheduleappdevelop.dto.*;
import com.scheduleappdevelop.entity.User;
import com.scheduleappdevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;



import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/scheduleUsers")
public class UserController {

    private final UserService userService;

    //유저 생성 -> 회원가입
    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
//        User user = userService.register(request);
//        RegisterResponse response = new RegisterResponse(user.getId());
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
    public ResponseEntity<LoginResponse> login(
//            @SessionAttribute // Session ID만 편하게 다!”가져 올 수 있는 ArgumentResolver
            // @Valid 클라이언트가 보낸 요청메세지에 담겨있는 데이터 자체를 입구에서 검증 하는 어노테이션
            // 로그인한 사용자를 기억해주는 저장소, 스프링이 요청이 들어올 때 자동으로 현재 사용자의 세션 객체를 넣어줌
            @Valid @RequestBody LoginRequest request, HttpServletRequest session) {

        //서비스 로직 데이터 검증
        User user = userService.login(request);

        //입력받은 session에 세션 부분만 뽑아내기 ,최초 로그인 시 세션 자동 생성
        HttpSession userSession = session.getSession();

        //세션 생성 및 저장 - 로그인 한 유저 자동저장
        //setAttribute - HTTP 요청이 시작부터 끝날때 까지 유지되는 임시 저장소
        //
        userSession.setAttribute("loginUser", user.getId());

        //로그인 성공후 본인 데이터 돌려보내주면서 확인시켜주기
//        LoginResponse response = new LoginResponse(
//                user.getId(),
//                user.getEmail()
//        );

        return ResponseEntity.ok(new LoginResponse(user.getId(), user.getEmail()));
    }


}
