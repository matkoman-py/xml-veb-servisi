package com.example.VaccinationApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@SpringBootApplication
public class VaccinationApplication {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println((String) (dtf.format(now)));  
		SpringApplication.run(VaccinationApplication.class, args);
		
	}
}
