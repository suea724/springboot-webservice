package com.spring.sue.springboot.web.dto;

import com.spring.sue.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto { // 수정화면으로 전달할 DTO

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    private String content;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.content = entity.getContent();
    }

}
