package com.jojoldu.book.springboot.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter //lombok  - 모든 필드의 getter method 생성
@NoArgsConstructor //lombok  - 기본 생성자 자동 추가
@Entity //JPA annotation
public class Posts {//Entity 클래스
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition="TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
