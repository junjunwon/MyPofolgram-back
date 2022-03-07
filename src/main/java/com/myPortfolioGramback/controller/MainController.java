package com.myPortfolioGramback.controller;

import com.myPortfolioGramback.common.Success;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class MainController {

    @PostMapping("/axiosTest")
    public @ResponseBody Success axiosTest(HttpServletRequest request) {

        String testValue = request.getParameter("testValue");
        Success success = new Success(false);

        success.setResult(testValue);
        success.setSuccess(true);
        return success;

    }
//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
}
