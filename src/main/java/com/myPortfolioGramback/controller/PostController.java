package com.myPortfolioGramback.controller;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.likes.SaveLikeDto;
import com.myPortfolioGramback.domain.post.PostDetailDto;
import com.myPortfolioGramback.domain.post.SavePostDto;
import com.myPortfolioGramback.domain.userInfo.SetUser;
import com.myPortfolioGramback.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
     * 간략한 리스트 조회로 postId, 첫번째 photo 이미지 url만 호출
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

    /**
     * get whole information of Post List
     *
     * @author jh.won
     * @since 2022.05.07
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/getPostListDetail")
    public @ResponseBody Success getPostListDetail(
            HttpServletRequest request,
            @RequestParam("userId") String userId
    ) {
        Success success = postService.getPostListDetail(userId);

        return success;
    }

    /**
     * get commentList by postId
     *
     * @author jh.won
     * @since 2022.05.07
     * @param request
     * @param postId
     * @return
     */
    @GetMapping("/getCommentList")
    public @ResponseBody Success getCommentList(
            HttpServletRequest request,
            @RequestParam("postId") String postId
    ) {
        Success success = postService.getCommentList(postId);

        return success;
    }

    @PostMapping("/saveLikeForPost")
    public @ResponseBody Success saveLikeForPost(
            HttpServletRequest request,
            @RequestBody SaveLikeDto saveLikeDto
//            @RequestParam("userId") String userId,
//            @RequestParam("postId") String postId,
//            @RequestParam("isLiked") String isLiked
    ) {
        String userId = saveLikeDto.getUserId();
        String postId = saveLikeDto.getPostId();
        String isLiked = saveLikeDto.getIsLiked();

        Success success = postService.saveLikeForPost(userId, postId, isLiked);

        return success;
    }

    @PostMapping("/savePost")
    public @ResponseBody Success savePost(
            HttpServletRequest request,
            SavePostDto savePostDto
    ) throws IOException {
        PostDetailDto postDetailDto = new PostDetailDto();
        Success success = postService.savePost(savePostDto);

        return success;
    }
}
