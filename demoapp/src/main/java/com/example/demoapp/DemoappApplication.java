package com.example.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoappApplication.class, args);
//		System.out.println(context.getBeanDefinitionCount());
//
//		String[] names = context.getBeanDefinitionNames();
//		Arrays.stream(names).forEach(System.out::println);
	}


}
