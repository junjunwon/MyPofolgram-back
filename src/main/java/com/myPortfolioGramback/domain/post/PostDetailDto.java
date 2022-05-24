package com.myPortfolioGramback.domain.post;

import com.myPortfolioGramback.domain.userInfo.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PostDetailDto {
    private int id;
    private String userImgUrl;
    private String nickName;
    private long userId;
    private List<String> photoImgUrl;
    private String content;
//    private LocalDateTime createDate;
    private int commentCount;
    private int likeCount;
    private String isLiked;
    private List<?> hashTags;
}
