package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"com"})
@EntityScan(basePackages = {"com"})
public class ErsMavenApplication {

	public static void main(String[] args) throws InterruptedException
	{
		SpringApplication.run(ErsMavenApplication.class, args);
	}

}
