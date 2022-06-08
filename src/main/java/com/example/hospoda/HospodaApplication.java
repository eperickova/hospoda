package com.example.hospoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class HospodaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospodaApplication.class, args);
	}

}
