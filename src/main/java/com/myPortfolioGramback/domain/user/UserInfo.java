package com.myPortfolioGramback.domain.user;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="UserInfo")
public class UserInfo {
    @Id
    @Column(name="userId")
    private String userId;

    @Column(name="password")
    private String password;

    @Column(name="userName")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="mobile")
    private String mobile;

    @Column(name = "createDate")
    @CreationTimestamp
    private LocalDate createDate;
}
