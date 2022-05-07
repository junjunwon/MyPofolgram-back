package com.myPortfolioGramback.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.userInfo.SetUser;
import com.myPortfolioGramback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * The type User controller.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private final UserService userService;

    /**
     * 유저 전체 정보 조회
     *
     * @param request the request
     * @param userId  the user id
     * @return 전체 userInfo, follwer count, follwee count
     * @throws JsonProcessingException the json processing exception
     * @author jh.won
     * @since 2022.04
     */
    @GetMapping("/getUserInfo")
    public @ResponseBody Success getUserInfo(
            HttpServletRequest request,
            @RequestParam("userId") String userId) throws JsonProcessingException {

        Success success = userService.getUserInfo(userId);

        return success;
    }

    /**
     * 프로필 수정 정보 조회
     *
     * @param request the request
     * @param userId  the user id
     * @return id, userId, userName, email, mobile, website, intro
     * @author jh.won
     * @since 2022.04.30
     */
    @GetMapping("/getProfileInfo")
    public @ResponseBody Success getProfileInfo(
            HttpServletRequest request,
            @RequestParam("userId") String userId ) {
        Success success = userService.getProfileInfo(userId);

        return success;
    }

    /**
     * 유저정보 저장
     *
     * @param setUser (systemId, type, value)
     * @param request the request
     * @return true / false
     * @author jh.won
     * @since 2022.04
     */
    @PostMapping("/setUserInfo")
    public @ResponseBody Success setUserInfo(
            @RequestBody SetUser setUser,
            HttpServletRequest request
    ) {
        Success success = userService.setUserInfo(setUser);

        return success;
    }

    /**
     * 팔로우 정보 조회
     *
     * @param request the request
     * @param userId  the user id
     * @return follower count, follwee count, followerList, followeeList
     * @author jh.won
     * @since 2022.04
     */
    @GetMapping("/getFollowList")
    public @ResponseBody Success getFollowList(
            HttpServletRequest request,
            @RequestParam("userId") String userId
    ) {
        Success success = userService.getFollowList(userId);

        return success;
    }
}
