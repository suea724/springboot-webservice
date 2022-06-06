package com.spring.sue.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// DB에 접근할 JpaRepository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // SpringJPA가 제공하지 않는 메서드는 쿼리문을 직접 지정해서 정의
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
