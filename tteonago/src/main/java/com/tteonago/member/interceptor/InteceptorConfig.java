package com.tteonago.member.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
 * 인터셉터를 적용시킬 범위를 지정합니다
 */
@Configuration
public class InteceptorConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new Interceptor()).addPathPatterns("/category"); // 인터셉터를 적용할 url
//				.excludePathPatterns("/getName") // 인터셉터에서 제외할 url
//				.excludePathPatterns("/getToken") 
//				.excludePathPatterns("/logout") 
//				.excludePathPatterns("/getTokenName"); 
	}
}
