package com.chae.security_study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*
    * curl http://localhost:8080/hello 호출 시 응답 x
    *
    * 애플리케이션 실행 시 콘솔에 찍히는 패스워드를 헤더에 넣어서 보내면 인증 절차가 완료됨
    * curl -u user:111a79ca-2802-4368-a2b9-a463ef10154b http://localhost:8080/hello
    *  curl -H "Authorization: Basic dXNlcjoxMTFhNzljYS0yODAyLTQzNjgtYTJiOS1hNDYzZWYxMDE1NGI=" http://localhost:8080/hello
    * <username>:<password> 를 base64로 인코딩
     * */
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
