package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan(basePackages = "com.tandat.Forum,controller,model")
@ComponentScan({ "com.tandat.Forum", "controller", "model", "service", "respository", "SecurityConfig", "handler" })
@ConfigurationPropertiesScan({ "SecurityConfig" })
@EntityScan(basePackages = "model")
@EnableJpaRepositories("respository")
public class StoreApplication extends SpringBootServletInitializer {
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(StoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

}
