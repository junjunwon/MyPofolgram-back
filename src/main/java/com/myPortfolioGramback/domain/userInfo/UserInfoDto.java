package com.myPortfolioGramback.domain.userInfo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UserInfoDto {
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private String email;
    private String mobile;
    private LocalDateTime createDate;
    private String userImgUrl;

    private String website;
    private String intro;
    private long followerCnt;
    private long followeeCnt;
    private long postCnt;

//    private List<Follow> follows = new ArrayList<>();
}
