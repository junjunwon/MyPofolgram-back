package com.myPortfolioGramback.domain.likes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveLikeDto {

    private String userId;
    private String postId;
    private String isLiked;
}
