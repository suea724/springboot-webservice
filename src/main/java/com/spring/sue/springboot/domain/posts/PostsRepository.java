package com.spring.sue.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// DB에 접근할 JpaRepository
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
