package com.myPortfolioGramback.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
//    List<Post> findAllByUserInfo_idByOrderByCreateDateDesc(long userId);
    List<Post> findAllByOrderByCreateDateDesc();
}
