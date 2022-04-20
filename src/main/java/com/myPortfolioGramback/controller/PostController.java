package com.myPortfolioGramback.controller;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    PostService postService;

    @GetMapping("/getPostList")
    public @ResponseBody Success getPostList(
            HttpServletRequest request,
            @RequestParam("userId") String userId
    ) {

        Success success = postService.getPostList(userId);

        return success;
    }
}
