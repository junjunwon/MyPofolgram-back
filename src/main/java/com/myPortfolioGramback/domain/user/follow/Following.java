package com.myPortfolioGramback.domain.user.follow;

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
@Table(name="Following")
public class Following {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "follwerId")
    private Follower follower;

}
