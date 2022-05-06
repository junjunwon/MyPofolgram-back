package com.myPortfolioGramback.domain.user;

import com.myPortfolioGramback.domain.user.post.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="Comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @ManyToOne
    @JoinColumn(name="postId")
    private Post post;

    @Column(name="userId")
    private int userId;

    @Column(name="comment", columnDefinition = "VARCHAR (1000)")
    private String comment;

    @Column(name = "createDate")
    @CreationTimestamp
    private LocalDateTime createDate;
}
