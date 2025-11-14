package com.scheduleappdevelop.service;

import com.scheduleappdevelop.dto.*;
import com.scheduleappdevelop.entity.User;
import com.scheduleappdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //초기화 되지 않은 final 필드나, @NonNull이 붙은 필드에 대해 생성자를 생성해준다.
public class UserService {

    private final UserRepository userRepository;

    //회원가입
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) {

        //ifPresent()는 Optional 객체가 값을 가지고 있으면 실행 값이 없으면 넘어감
        userRepository.findByEmail(request.getEmail())
              .ifPresent(user -> {
                  throw new IllegalArgumentException("이미 사용중인 이메일 주소 입니다.");
              });

        //DTO -> 엔터티
        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        //DB저장
        User saved = userRepository.save(user);

        //DB -> 리퀘스트로
        return new CreateUserResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getCreatedAt(),
                saved.getModifiedAt()
        );
    }

    //유저 전체 조회
    @Transactional(readOnly = true)
    public List<AllUserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new AllUserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCreatedAt(),
                        user.getModifiedAt()
                )).toList();
    }

    // 유저 단건 조회
    @Transactional(readOnly = true)
    public SingleUserResponse getUserById(Long id) {
        // 입력 받은 키값이 데이터 베이스에 있는지 확인
//        Optional<User> optionalUserUser = userRepository.findById(id); //값이 있을수도 있고 없을수도 있으니 없나면 Optional<T>로 Null을 보내준다.
//        User user = optionalUserUser.get();

        User user = userRepository.findById(id).orElse(null);
//                .orElseThrow(() -> new IllegalArgumentException("해당 ID는 없는 유저 입니다.")); //ID 조회후 예외 처리까지 완료

        return new SingleUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    //유저 정보 수정
    @Transactional
    public UpdateUserResponse updateUser(Long id, UpdateUserRequest request) {
        //데이터베이스에 있는 아디이 인지 조회
        User user = userRepository.findById(id).orElse(null);

        //입력한 데이터가 엎어씌울수 있는지 확인
        if (request.getName() != null) {
            user.setName(request.getName());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }

        //DB에 저장
        User saved = userRepository.save(user);

        //DB -> 리퀘스트로 전달
        return new UpdateUserResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getCreatedAt(),
                saved.getModifiedAt()
        );
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.findById(id).orElse(null);
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        userRepository.deleteById(id);
    }
}
