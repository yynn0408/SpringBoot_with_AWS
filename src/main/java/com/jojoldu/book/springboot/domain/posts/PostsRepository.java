package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {//CRUD 메소드자동생성

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    // 보통 대규모 프로젝트에서는 데이터 조회시 FK 조인, 복잡한 조건등으로 Entity 클래스만으로 조회가 어려워 조회에 querydsl, myBatis등을 사용
    // (등록/수정/삭제) 는 SpringData Jpa
    // 그 중 querydsl 은
    // 1) 타입 안정성 보장 (메소드기반으로 쿼리를 생성하여 오타를 IDE에서 자동검출)
    // 2) 레퍼런스 많음

}
