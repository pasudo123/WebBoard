package edu.doubler.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestProcessingURL extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RequestProcessingURL.class);
	private static final String TRAILING_SLASHES = "/";
	
	// controller 가 수행되기 이전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info(":: preHandle ::");
		String requestURL = request.getRequestURL().toString();
		logger.info("Request URL : " + requestURL);
		
		// false 를 반환하고 sendRedirect 
		// 이후에 인터셉터 작동 X
		if(requestURL.endsWith(TRAILING_SLASHES)){
			requestURL = requestURL.substring(0, requestURL.length()-1);
			logger.info("TRAILING_SLASHES URL : " + requestURL);
			response.sendRedirect(requestURL);
			return false;
		}
		
		return true;
	}

	// controller 가 수행된 이후 view를 호출하기 전에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info(":: postHandle ::");
	}
	
	// view 작업이 완료된 후 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		logger.info(":: afterCompletion ::");
	}
}
