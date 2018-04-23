package edu.doubler.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * junit 4.12 이상버전에서 이용
 * https://www.mkyong.com/unittest/junit-spring-integration-example/
 * **/

	
@Configuration
@ComponentScan(basePackages = {"edu.doubler.demo"})
public class AppConfig {}
