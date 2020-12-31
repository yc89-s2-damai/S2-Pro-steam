package com.yc.steam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableTransactionManagement

public class SteamApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SteamApplication.class, args);
	}
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * System.out.println("==========================="); String filepath =
	 * "D:\\Git\\steam\\S2-Pro-steam\\src\\main\\resources\\static\\assets\\images";
	 * registry.addResourceHandler("/assets/images/**").addResourceLocations("file:"
	 * + filepath); // WebMvcConfigurer.super.addResourceHandlers(registry); //
	 * registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.
	 * CLASSPATH_URL_PREFIX // + "/static/"); }
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("===========================");
		String filepath = "/root/a/";
		registry.addResourceHandler("/**").addResourceLocations("file:" + filepath);
		// WebMvcConfigurer.super.addResourceHandlers(registry);
		 registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX
		 + "/static/");
	}
	
}
