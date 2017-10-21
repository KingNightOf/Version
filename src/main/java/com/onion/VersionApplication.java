package com.onion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class VersionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VersionApplication.class, args);
	}

}
