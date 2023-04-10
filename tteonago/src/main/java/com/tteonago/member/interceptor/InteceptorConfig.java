package com.tteonago.member.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
 * 인터셉터를 적용시킬 범위를 지정합니다
 */
@Configuration
public class InteceptorConfig implements WebMvcConfigurer { //팀원 합의 -> 클래스 이름 오타 : InterceptorConfig로 변경***********
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new Interceptor()).addPathPatterns("/category"); 
        // .excludePathPatterns("/getName")
	}
}