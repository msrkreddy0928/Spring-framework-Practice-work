package com.example.Loggingmvc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingMvcApplication.class, args);

	}


	@Setter
	@Getter
	@AllArgsConstructor
	public static class Productnew {
		private int id;
		private String name;
		private double cost;

	}
}
