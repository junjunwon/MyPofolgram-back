package com.myPortfolioGramback.domain.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter @Setter
public class UserInfoDto {
    private String userId;
    private String password;
    private String userName;
    private String email;
    private String mobile;
    private LocalDate createDate;
}
