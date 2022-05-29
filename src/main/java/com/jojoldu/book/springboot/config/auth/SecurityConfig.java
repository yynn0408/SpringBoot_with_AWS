package com.jojoldu.book.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import com.jojoldu.book.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable()
                .and().authorizeRequests()//URL별 권한 관리 설정.  AntMatchers 옵션 사용하기 위해 권한 관리설정함.
                    .antMatchers("/", "/css/**", "/images/**","/js/**","/h2-console/**").permitAll()//권한 관리 대상 지정
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())//api/v1 주소를 가진 API는 USER권한 가진 사람만 가능
                    .anyRequest().authenticated()//나머지 URL는 로그인한 사용자들에게만 가능하도록
                .and().logout().logoutSuccessUrl("/")//로그아웃 하면 /주소로 이동
                .and().oauth2Login().userInfoEndpoint()//OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정
                .userService(customOAuth2UserService);//소셜 로그인 성공 시 후속조치를 할 UserService 인터페이스 구현체 등록(사용자 정보 가져오고나서 추가로 진행할 기능 명시가능)

    }

}
