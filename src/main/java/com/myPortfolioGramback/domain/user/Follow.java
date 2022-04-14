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
@Table(name="Follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserInfo userInfo;

    @Column(name = "followerId")
    private String follower;

    @Column(name = "followingId")
    private String followingId;

}
