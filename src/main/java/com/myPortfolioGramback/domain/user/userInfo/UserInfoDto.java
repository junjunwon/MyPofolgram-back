package com.myPortfolioGramback.domain.user.userInfo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class UserInfoDto {
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private String email;
    private String mobile;
    private LocalDateTime createDate;


    private String website;
    private String introduction;
    private long followerCnt;
    private long followeeCnt;
    private long postCnt;

//    private List<Follow> follows = new ArrayList<>();
}
