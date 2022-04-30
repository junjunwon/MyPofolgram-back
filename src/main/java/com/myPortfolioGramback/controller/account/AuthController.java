package com.myPortfolioGramback.controller.account;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.security.LoginDto;
import com.myPortfolioGramback.domain.user.security.TokenDto;
import com.myPortfolioGramback.jwt.JwtFilter;
import com.myPortfolioGramback.jwt.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/api")
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    /**
     * Instantiates a new Auth controller.
     *
     * @param tokenProvider                the token provider
     * @param authenticationManagerBuilder the authentication manager builder
     */
    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    /**
     * 유저정보 검증 및 로그인
     *
     * @param loginDto the login dto
     * @return token jwt
     * @author jh.won
     * @since 2022.04
     */
    @PostMapping("/authenticate")
    public Success authorize(@Valid @RequestBody LoginDto loginDto) {

        Success success = new Success(true);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("token", new TokenDto((jwt)));
        dataMap.put("httpHeaders", httpHeaders);
        dataMap.put("HttpStatus", HttpStatus.OK);
        dataMap.put("userId", loginDto.getUsername());

        success.setResult(dataMap);
//        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
        return success;
    }
}
