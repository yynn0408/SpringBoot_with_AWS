package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 실제 DB와 동일한 스키마인 Entity와는 별도로 Dto가 필요함.
// 목적 : 1) 화면 변경시마다 Entity 를 변경하게되면 코드 수정량이 많음.
//       2) 실제 Controller 에서는 여러 테이블을 조인한 결과를 표출해야할 경우가 많음.
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }

}
