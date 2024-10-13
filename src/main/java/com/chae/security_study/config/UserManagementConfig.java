package com.chae.security_study.config;

import com.chae.security_study.security.CustomAuthenticationProvider;
import com.chae.security_study.service.InMemoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/*
* UserDetailService 구현을 재정의하는 방법을 알아보기 위한 예제
* 메모리에 자격 증명을 저장해서 스프링 시큐리티가 요청을 인증할 때 이용할 수 있게 함
* */
@Configuration // 클래스를 구성 클래스로 표시
public class UserManagementConfig {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;


    /*
    * 콘솔에 자동 생성된 암호가 출력되지 않음 -> 컨텍스트에 추가된 UserDetailService 형식의 인스턴스를 이용함.
    * */
    @Bean // 반환된 인스턴스를 스프링 컨텍스트에 빈으로 추가하도록 스프링에 지시
    public UserDetailsService userDetailsService(){

        UserDetails u = new User("chae", "test",List.of(()->"read"));
        List<UserDetails> users = List.of(u);

        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
