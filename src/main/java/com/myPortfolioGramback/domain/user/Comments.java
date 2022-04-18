package com.myPortfolioGramback.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name="email", columnDefinition = "VARCHAR (100)")
    private String email;

    @Column(name="userId")
    private int userId;

    @Column(name="postId")
    private int postId;
}