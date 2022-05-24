package com.myPortfolioGramback.domain.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter @Setter
public class SavePostDto {
    List<MultipartFile> multipartFiles;
    PostDetailDto postDetailDto;
}
