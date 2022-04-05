package com.myPortfolioGramback.repository;

import com.myPortfolioGramback.domain.user.UserInfo;
import com.myPortfolioGramback.domain.user.UserRepository;
import com.myPortfolioGramback.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
