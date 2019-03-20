package ch29.k1;

import org.springframework.context.annotation.ComponentScan;

//Mybatis와 Spring IoC Container를 연동하는 설정
//=> Mybatis 관련 빈 설정

// 스프링 IoC 컨테이너에 다른 설정이 들어있는 Java config 파일이 있는 위치를 알려준다.
@ComponentScan("ch29.k1")
public class AppConfig {
  
}






