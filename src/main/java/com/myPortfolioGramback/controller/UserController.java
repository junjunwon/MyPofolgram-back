package com.myPortfolioGramback.controller;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/getProfileInfo")
    public @ResponseBody Success getProfileInfo(
            HttpServletRequest request,
            @RequestParam("userId") String userId) {

        Success success = userService.getProfileInfo(userId);

        return success;
    }
}
