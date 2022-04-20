package com.myPortfolioGramback.domain.user;

import com.myPortfolioGramback.domain.user.post.Post;
import com.myPortfolioGramback.domain.user.userInfo.UserInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="Likes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @ManyToOne
    @JoinColumn(name="userId")
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name="postId")
    private Post post;
}
