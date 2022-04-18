package com.myPortfolioGramback.domain.user.userInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUserId(String userId);
}
