package com.myPortfolioGramback.config;

import com.myPortfolioGramback.jwt.JwtAccessDeniedHandler;
import com.myPortfolioGramback.jwt.JwtAuthenticationEntryPoint;
import com.myPortfolioGramback.jwt.JwtSecurityConfig;
import com.myPortfolioGramback.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableGlobalMethodSecurity(
//        //securedEnabled = true, jsr250Enabled = true
//        prePostEnabled = true
//)
//@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //pre-authorize annotaion을 method 단위로 사용하기 위해 추가.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public WebSecurityConfig(TokenProvider tokenProvider,
                             JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                             JwtAccessDeniedHandler jwtAccessDeniedHandler) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //token방식이므로 csrf 사용 안함.
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and() //h2-console을 위한 콘솔?
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션을 사용하지 않으므로 stateless

                .and()
                .authorizeRequests() //HttpServletReqeust를 사용하는 요청들에 대한 접근 제한을 설정
                        .antMatchers("/").permitAll()
                        .anyRequest().authenticated()

                .and()
                .apply(new JwtSecurityConfig(tokenProvider));

    }
}
