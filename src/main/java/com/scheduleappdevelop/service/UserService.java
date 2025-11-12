package com.scheduleappdevelop.service;

import com.scheduleappdevelop.dto.CreateUserRequest;
import com.scheduleappdevelop.dto.CreateUserResponse;
import com.scheduleappdevelop.entity.User;
import com.scheduleappdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //초기화 되지 않은 final 필드나, @NonNull이 붙은 필드에 대해 생성자를 생성해준다.
public class UserService {

    private final UserRepository userRepository;

    //생성
    public CreateUserResponse createUser(CreateUserRequest userData){

        //DTO -> 엔터티
        User user = new User(
        userData.getName(),
        userData.getEmail(),
        userData.getPassword()
        );

        //DB저장
        User saveduser = userRepository.save(user);

        //DB -> 리퀘스트로
        return new CreateUserResponse(
                saveduser.getId(),
                saveduser.getName(),
                saveduser.getEmail(),
                saveduser.getCreatedAt(),
                saveduser.getModifiedAt()
        );
    }
}
