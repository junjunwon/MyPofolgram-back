package com.myPortfolioGramback.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.userInfo.SetUser;
import com.myPortfolioGramback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private final UserService userService;

    @GetMapping("/getUserInfo")
    public @ResponseBody Success getUserInfo(
            HttpServletRequest request,
            @RequestParam("userId") String userId) throws JsonProcessingException {

        Success success = userService.getUserInfo(userId);

        return success;
    }

    @GetMapping("/getProfileInfo")
    public @ResponseBody Success getProfileInfo(
            HttpServletRequest request,
            @RequestParam("userId") String userId ) {
        Success success = userService.getProfileInfo(userId);

        return success;
    }

    @PostMapping("/setUserInfo")
    public @ResponseBody Success setUserInfo(
            @RequestBody SetUser setUser,
            HttpServletRequest request
    ) {
        Success success = userService.setUserInfo(setUser);

        return success;
    }

    @GetMapping("/getFollowList")
    public @ResponseBody Success getFollowList(
            HttpServletRequest request,
            @RequestParam("userId") String userId
    ) {
        Success success = userService.getFollowList(userId);

        return success;
    }
}
