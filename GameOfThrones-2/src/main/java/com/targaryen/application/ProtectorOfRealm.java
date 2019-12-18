package com.targaryen.application;

import java.text.ParseException;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProtectorOfRealm {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ProtectorOfRealm.class, args); //Main Class that starts springBoot project
	}
	
}
