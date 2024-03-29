package com.spring.sue.springboot.domain.posts;

import com.spring.sue.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 테이블과 링크될 클래스
@NoArgsConstructor
@Getter
@Entity
public class Posts extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 500, nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 직접적으로 수정 쿼리 날림
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
