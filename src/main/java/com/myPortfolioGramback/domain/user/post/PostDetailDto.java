package com.myPortfolioGramback.domain.user.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PostDetailDto {
    private int id;
    private String userImgUrl;
    private String photoImgUrl;
    private String content;
    private LocalDateTime createDate;
    private int commentCount;
    private String isLiked;
    private List<?> hashTags;
}
