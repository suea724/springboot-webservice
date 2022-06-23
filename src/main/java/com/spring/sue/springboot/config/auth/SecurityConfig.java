package com.spring.sue.springboot.config.auth;

import com.spring.sue.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 disable
                .and()
                    .authorizeRequests() // URL별 권한 관리 설정
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll() // 전체 열람 권한 부여할 URL 설정
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한을 가진 사람만 권한을 가지는 URL
                    .anyRequest().authenticated() // 설정한 값 이외 나머지 URL은 로그인한 사용자에게 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                    .userInfoEndpoint() // 로그인 성공 이후 사용자 정보를 가져올 때 설정
                        .userService(customOAuth2UserService); // 소셜 로그인 성공 시 기능 구현체
    }
}
