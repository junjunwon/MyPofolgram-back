package com.myPortfolioGramback.domain.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class PostDto {

    private String content;
    private String userId;
    private String userImgUrl;
    private List<String> photoImgUrl;
    private LocalDateTime createDate;
    private int commentCount;
    private int likeCount;
    private String isLiked;
    private List<?> hashTags;
}
