package com.scheduleappdevelop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id //기본 키값(PK)-주민등록번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 값을 DB가 자동으로 만듬
    private Long id;

    //작성자명
    @Column(length = 50, nullable = false,unique = true) //작성자명 글자수는 50자, 칼럼에 값이 없으면 안됨, unique = true데이터 베이스 칼럼 열 기준 중복 방지용
    private String name;

    //유저 이메일
    @Column(length = 70, nullable = false,unique = true) //이메일 글자수는 70자, 칼럼에 값이 없으면 안됨, unique = true데이터 베이스 칼럼 열 기준 중복 방지용
    private String email;

    //유저 비밀번호
    @Column(length = 50, nullable = false) //비밀번호의 길이는 50자, 칼럼에 값이 없으면 안됨
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //기본생성자
    protected User() {
    }

    //Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
