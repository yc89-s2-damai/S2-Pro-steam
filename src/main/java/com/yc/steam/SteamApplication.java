package com.yc.steam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SteamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteamApplication.class, args);
	}
	
}
