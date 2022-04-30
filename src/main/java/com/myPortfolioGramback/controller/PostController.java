package com.myPortfolioGramback.controller;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
@PreAuthorize("isAuthenticated()")
public class PostController {

    private final PostService postService;

    @GetMapping("/getPostList")
    public @ResponseBody Success getPostList(
            HttpServletRequest request,
            @RequestParam("userId") String userId
    ) {

        Success success = postService.getPostList(userId);

        return success;
    }
}
