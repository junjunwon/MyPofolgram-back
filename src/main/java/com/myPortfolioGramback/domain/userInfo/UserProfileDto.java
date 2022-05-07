package com.myPortfolioGramback.domain.userInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDto {
    private Long id;
    private String userId;
    private String userName;
    private String email;
    private String mobile;

    private String website;
    private String intro;
}
