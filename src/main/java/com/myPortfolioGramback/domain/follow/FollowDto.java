package com.myPortfolioGramback.domain.follow;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FollowDto {

    private int id;
    private String follower;
    private String followingId;
    private int userid;
}
