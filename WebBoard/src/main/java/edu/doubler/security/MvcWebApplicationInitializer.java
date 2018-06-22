package edu.doubler.security;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * Spring security 를 기존 ApplicationContext 에 등록하여야 한다.
 * Spring MVC를 사용한다면, 아래와 같은 코드로 상속받는다.
 * 
 * AbstractAnnotationConfigDispatcherServletInitializer 는
 * 애플리케이션이 Spring 을 사용하고 있는지 혹은 Spring Security 만 사용하고 있는지에 따라 다르다.
 * 
 * **/
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	// 애플리케이션의 모든 URL에 대해서 SpringSecurityFilterChain 만 등록하면 된다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {return null;}

	@Override
	protected String[] getServletMappings() {return null;}
	
}
