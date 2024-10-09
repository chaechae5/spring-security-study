package com.chae.security_study.config;

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
public class ProjectConfig {

    /*
    * 콘솔에 자동 생성된 암호가 출력되지 않음 -> 컨텍스트에 추가된 UserDetailService 형식의 인스턴스를 이용함.
    * */
    @Bean // 반환된 인스턴스를 스프링 컨텍스트에 빈으로 추가하도록 스프링에 지시
    public UserDetailsService userDetailsService(){
        var userDetailsService = new InMemoryUserDetailsManager(); //var : 로컬 선언에만 이용, 변수 형식 숨김

        var user = User.withUsername("chae")
                .password("test")
                .authorities("read")
                .build();
        userDetailsService.createUser(user); //userDetailsService에서 관리하도록 사용자 추가

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /*
    * spring Security 5.7부터는 WebSecurityConfigurerAdapter deprecated
    * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // HTTP Basic 인증을 활성화합니다.
                .httpBasic(Customizer.withDefaults()) // Deprecated된 httpBasic() 대신 사용
                // 모든 요청에 대해 인증 없이 접근 허용
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
