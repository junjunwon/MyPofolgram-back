package com.myPortfolioGramback.domain.user.follow;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollowingId(String followingId);

    List<Follow> findByFollower(String follower);
}
