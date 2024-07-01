package com.example.RestTemplatedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RestTemplateDemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(RestTemplateDemoApplication.class, args);
	}

}
