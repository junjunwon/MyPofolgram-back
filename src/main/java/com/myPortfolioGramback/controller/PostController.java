package com.myPortfolioGramback.controller;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Post controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
@PreAuthorize("isAuthenticated()")
public class PostController {

    private final PostService postService;

    /**
     * 게시물 리스트 조회 API
     *
     * @param request the request
     * @param userId  the user id
     * @return postId, imgUrl
     * @autor jh.won
     * @since 2022.04
     */
    @GetMapping("/getPostList")
    public @ResponseBody Success getPostList(
            HttpServletRequest request,
            @RequestParam("userId") String userId
    ) {

        Success success = postService.getPostList(userId);

        return success;
    }

    @GetMapping("/getPostListDetail")
    public @ResponseBody Success getPostListDetail(
            HttpServletRequest request,
            @RequestParam("userId") String userId
    ) {
        Success success = postService.getPostListDetail(userId);

        return success;
    }
}
