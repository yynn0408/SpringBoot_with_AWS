package com.jojoldu.book.springboot.domain.posts;
import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter //lombok  - 모든 필드의 getter method 생성
@NoArgsConstructor //lombok  - 기본 생성자 자동 추가
@Entity //JPA annotation
public class Posts extends BaseTimeEntity {//Entity 클래스
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
    //트랜잭션이 끝나는 시점에 해당 테이블에 변경분 반영. (더티체킹)
    //트랜잭션이 끝났을 때 상태 변화(스냅샷)가 생기면 DB에 자동 반영
    //entity 상단에 @DynamicUpdate 선언시, 변경된 필드만 update
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
