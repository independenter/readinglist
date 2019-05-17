package com.asiainfo.readinglist;

import com.asiainfo.readinglist.filter.LogbackFilter;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.DispatcherType;
import java.util.EnumSet;


//应用程序的启动类
//@EnableAutoConfiguration()
@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class,
		//DataSourceAutoConfiguration.class,
}) //开启组件扫描和自动配置  @Configuration,@EnableAutoConfiguration和 @ComponentScan
@ServletComponentScan
public class ReadinglistApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ReadinglistApplication.class, args); //负责启动引导应用程序
		SpringApplication app = new SpringApplication(ReadinglistApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}

//	@RequestMapping("/error")
//	public String showIndex(){
//		return "error";
//	}

	@Bean
	public FilterRegistrationBean testLogbackFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new LogbackFilter());
		registration.addUrlPatterns("/*"); //
		//registration.addInitParameter("paramName", "paramValue"); //
		registration.setName("logbackFilter");
		registration.setOrder(1);//执行顺序
		return registration;
	}
	@Bean
	public ErrorPageRegistrar errorPageRegistrar(){
		return new MyErrorPageRegistrar();
	}
	// 错误页注册
	private static class MyErrorPageRegistrar implements ErrorPageRegistrar {
		@Override
		public void registerErrorPages(ErrorPageRegistry registry) {
			registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
		}
	}

	/**
	 * 过滤所有过来的请求4
	 * @return
	 */
	//@Bean
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		//registration.setFilter(new MyFilter());
		registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		return registration;
	}
}