package com.myPortfolioGramback.domain;

import com.myPortfolioGramback.domain.post.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="Photos")
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postid")
    private Post post;

    @Column(name="fileName", columnDefinition = "VARCHAR (255)")
    private String fileName;

}
