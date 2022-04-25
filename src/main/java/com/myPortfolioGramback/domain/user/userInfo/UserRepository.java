package com.myPortfolioGramback.domain.user.userInfo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUserId(String userId);

    /**
     * @EntityGraph 는 쿼리가 수행이 될때 Lazy 조회가 아니고, Eager 조회로 Authorities 정보를 같이 가져오게 된다.
     * @param userId
     * @return
     */
    @EntityGraph(attributePaths = "authorities")
    Optional<UserInfo> findOneWithAuthoritiesByUserId(String userId);
}
