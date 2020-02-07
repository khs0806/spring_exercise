package com.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.example.model.Freeboard;
import com.example.model.Users;
import com.example.repository.FreeboardRepository;
import com.example.repository.UsersRepository;
import com.example.service.UserPasswordHashClass;

@SpringBootApplication
public class ExampleProjectApplication {
	
	@Autowired
    private UsersRepository usersRepository;
    @Autowired
    private FreeboardRepository freeboardRepository;
    @Autowired
    private UserPasswordHashClass userPasswordHashClass;
	
	public static void main(String[] args) {
		SpringApplication.run(ExampleProjectApplication.class, args);
	}
	
    
}
