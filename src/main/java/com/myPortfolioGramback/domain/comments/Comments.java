package com.myPortfolioGramback.domain.comments;

import com.myPortfolioGramback.domain.post.Post;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

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
