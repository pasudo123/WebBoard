package edu.doubler.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"edu.doubler"})
public class AppConfig {}

/**
 * [ 참고자료  ]
 * (1) https://examples.javacodegeeks.com/core-java/junit/spring-junit-test-example/
 * (2) https://www.mkyong.com/unittest/junit-spring-integration-example/
 *
 * @RunWith
 * - 특정 러너 클래스로 실행해야 하는 클래스에 태그를 지정하는 주석
 * - JUnit 에 대안적인 러너가 많이 있지만, Spring Test 를 사용하고 있으므로
 * - SpringJUnit4ClassRunner.class 를 사용한다.
 * 
 * 
 * @ContextConfiguration
 * - ClassPathContextConfiguration을 호출하는 것과 유사
 * - 해당 클래스는 우리 클래스의 어떤 유형의 ContextLoader 와 자바 클래스 파일에 사용 가능
 * - 
 **/
