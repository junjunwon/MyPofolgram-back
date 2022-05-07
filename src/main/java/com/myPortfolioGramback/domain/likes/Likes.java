package com.myPortfolioGramback.domain.likes;

import com.myPortfolioGramback.domain.post.Post;
import com.myPortfolioGramback.domain.userInfo.UserInfo;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
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
