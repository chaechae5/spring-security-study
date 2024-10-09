package com.chae.security_study.config;

import com.chae.security_study.security.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
* UserDetailService 구현을 재정의하는 방법을 알아보기 위한 예제
* 메모리에 자격 증명을 저장해서 스프링 시큐리티가 요청을 인증할 때 이용할 수 있게 함
* */
@Configuration // 클래스를 구성 클래스로 표시
public class WebAuthorizationConfig {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    /*
    * spring Security 5.7부터는 WebSecurityConfigurerAdapter deprecated
    * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authenticationProvider) // authenticationProvider 등록
                // HTTP Basic 인증을 활성화합니다.
                .httpBasic(Customizer.withDefaults()) // Deprecated된 httpBasic() 대신 사용
                // 모든 요청에 대해 인증 없이 접근 허용
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
