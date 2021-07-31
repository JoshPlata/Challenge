package com.josue.sample.Configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.josue.sample.Entity")
@EnableJpaRepositories("com.josue.sample.Repository")
@ComponentScan(basePackages = {
		"com.josue.sample.Controller",
		"com.josue.sample.Repository",
		"com.josue.sample.Service"
})
@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
