//package edu.doubler.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//
///**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// * 
// * [ SpringSecurityFilterChain 을 만듦 ]
// * - Spring Security Java Configuaration 을 생성
// * - 애플리케이션의 모든 보안들을 담당
// * - springSecurityFilterChain 이라는 서블릿 필터를 생성
// * 
// * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Bean
//	public UserDetailsService userDetailsService(){
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
//		return manager;
//	}
//	
//	// 사용자 인증정보 뿐만 아니라 주어진 양식에 대한 인증을 지원하고자 하는경우, 다음과 같은 구성
//	protected void configure(HttpSecurity http) throws Exception{
//		/** EX) ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//		 * 애플리케이션에 대한 모든 요청이 사용자의 인증을 요구하도록 지정 : .authroizedRequest()
//		 * 사용자가 양식 기반 로그인을 사용하여 인증할 수 있도록 : .formLogin()
//		 * 사용자가 HTTP 기본 인증을 사용하여 인증할 수 있도록 : .httpBasic()
//		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
//		http.authorizeRequests()	
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/login")	// 로그인 페이지 위치 지정
//				.permitAll();			// 모든 사용자에게 (인증되지 않은) 액세스권한을 부여
//	}									
//}
