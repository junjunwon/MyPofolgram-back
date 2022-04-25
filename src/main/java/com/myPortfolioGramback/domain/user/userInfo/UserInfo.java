package com.myPortfolioGramback.domain.user.userInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myPortfolioGramback.domain.user.Likes;
import com.myPortfolioGramback.domain.user.Settings;
import com.myPortfolioGramback.domain.user.follow.Follow;
import com.myPortfolioGramback.domain.user.post.Post;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Table(name="UserInfo")
public class UserInfo {

    @Id
    @JsonIgnore
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

//    @JsonIgnore
//    @Column(name = "activated")
//    private boolean activated;

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

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "authorityName", referencedColumnName = "authorityName")})
    private Set<Authority> authorities;

    public UserInfo(String subject, String userId, Collection<? extends GrantedAuthority> authorities) {
    }

}
