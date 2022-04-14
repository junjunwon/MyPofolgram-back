package com.myPortfolioGramback.controller;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.SetUser;
import com.myPortfolioGramback.domain.user.UserInfo;
import com.myPortfolioGramback.domain.user.UserInfoDto;
import com.myPortfolioGramback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/getProfileInfo")
    public @ResponseBody Success getProfileInfo(HttpServletRequest request) {

        Success success = userService.getProfileInfo();

        return success;
    }

    @PostMapping("/setProfile")
    public @ResponseBody Success setProfile(
            @RequestBody SetUser setUser,
            HttpServletRequest request
    ) {
//        Success success = userService.setProfile(type, value, systemId);
        Success success = userService.setProfile(setUser);

        return success;
    }
}
