package com.websystique.springmvc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.websystique.springmvc.service.UserServiceImpl;

@Component
public class InstanceConfig {
	
	@Bean
	public static  UserServiceImpl userService(){
		return new UserServiceImpl();

	}

}

