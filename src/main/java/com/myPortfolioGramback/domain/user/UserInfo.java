package com.myPortfolioGramback.domain.user;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="UserInfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @Column(name="userId")
    private String userId;

    @Column(name="nickName")
    private String nickName;

    @Column(name="password")
    private String password;

    @Column(name="email", columnDefinition = "VARCHAR (100)")
    private String email;

    @Column(name="mobile",columnDefinition = "VARCHAR (50)")
    private String mobile;

    @Column(name = "createDate")
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "updateDate")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column(name = "removeDate")
    private LocalDateTime removeDate;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Comments> comments = new ArrayList<>();

    @Column(name="userImgUrl", columnDefinition = "VARCHAR (255)")
    private String userImgUrl;

    @OneToOne
    @JoinColumn(name = "settingId")
    private Settings settings;

    @OneToMany(mappedBy = "userInfo")
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo")
    private List<Following> followings = new ArrayList<>();
}
