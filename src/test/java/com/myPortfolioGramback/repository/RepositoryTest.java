package com.myPortfolioGramback.repository;

import com.myPortfolioGramback.domain.userInfo.UserInfo;
import com.myPortfolioGramback.domain.userInfo.UserRepository;
import com.myPortfolioGramback.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {

    private UserRepository userRepository;

    public RepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserService userService;

    @Test
    public void test(){
        UserInfo userInfo = UserInfo.builder

    }
}
