package com.example.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalTransportSystemApplication {

	public static void main(String[] args) {
		System.out.println("Starting API :8080");
		SpringApplication.run(HospitalTransportSystemApplication.class, args);
	}

}
