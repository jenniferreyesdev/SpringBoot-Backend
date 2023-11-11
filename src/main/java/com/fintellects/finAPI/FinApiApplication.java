package com.fintellects.finAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class FinApiApplication {

	public static void main(String[] args) {

		System.setProperty("endpointUrl","http://some-bucket-name-s3.s3-website.us-east-2.amazonaws.com");
		System.setProperty("bucketName","some-bucket-name-s3");
		System.setProperty("accessKey","************");
		System.setProperty("secretKey","***********************");

		System.out.println("Hello2");
		SpringApplication.run(FinApiApplication.class, args);
		System.out.println("GoodBye2");

	}

}
