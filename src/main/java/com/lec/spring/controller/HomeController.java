package com.lec.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j          // Java 코드에서 반복적으로 작성되는 코드를 자동으로 생성해주는 라이브러리
@RestController
public class HomeController {

    @Value("${env.info}")
    private String envInfo;

    @GetMapping("/aws/v2")
    public String hello(@RequestParam(defaultValue = "1") Integer num){           // parameter 는 num 으로 받음
        if(num == 1){ // info 로그
            log.info("[" + envInfo + "] /aws/v2 이 호출. info 로그 #####################################");
        }else if(num == -1){ // error 로그
            log.error("[" + envInfo + "] /aws/v2 이 호출. error 로그 #####################################");
        }else if(num == 0){ // warn 로그
            log.warn("[" + envInfo + "] /aws/v2 이 호출. warn 로그 #####################################");
        }

        return "<h1>AWS 배포 v2</h1>";
    }

}
