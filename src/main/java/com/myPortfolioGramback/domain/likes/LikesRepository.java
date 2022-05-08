package com.myPortfolioGramback.domain.likes;

import com.myPortfolioGramback.domain.post.Post;
import com.myPortfolioGramback.domain.userInfo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    int deleteByPostAndUserInfo(Post post, UserInfo userInfo);
    Likes findByPostAndUserInfo(Post post, UserInfo userInfo);

}
