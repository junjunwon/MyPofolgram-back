package com.myPortfolioGramback.domain.user.userInfo;

import com.myPortfolioGramback.domain.user.Likes;
import com.myPortfolioGramback.domain.user.Settings;
import com.myPortfolioGramback.domain.user.follow.Follow;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="UserInfo")
public class UserInfo {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @Column(name="intro",columnDefinition = "VARCHAR (2000)")
    private String intro;

    @Column(name = "createDate")
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "updateDate")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column(name = "removeDate")
    private LocalDateTime removeDate;

//    @OneToMany
//    @JoinColumn(name = "id")
//    private List<Comments> comments = new ArrayList<>();

    @Column(name="userImgUrl", columnDefinition = "VARCHAR (255)")
    private String userImgUrl;

    @OneToOne
    @JoinColumn(name = "settingId")
    private Settings settings;

    @OneToMany(mappedBy = "userInfo")
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL)
    private List<Follow> follows = new ArrayList<>();
}
