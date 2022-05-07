package com.myPortfolioGramback.domain.comments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentsDto {

    private String nickName;
    private String userImgUrl;
    private String comment;
    private LocalDateTime createDate;
}
