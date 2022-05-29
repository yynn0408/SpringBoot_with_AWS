package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);//소셜 로그인 반환 값중 email을 통해서 이미 있는 사용자인지 처음 가입한 사용자인지 확인
}
