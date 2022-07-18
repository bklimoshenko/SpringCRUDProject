package com.bklimoshemko.SpringCRUD;

import com.bklimoshemko.SpringCRUD.entity.Student;
import com.bklimoshemko.SpringCRUD.entity.User;
import com.bklimoshemko.SpringCRUD.repository.StudentRepository;
import com.bklimoshemko.SpringCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class SpringCrudApplication {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

	@Bean
	public ApplicationRunner initStudents(){
		final Student defaultStudent1 = new Student(UUID.randomUUID(), "John", "Doe");
		final Student defaultStudent2 = new Student(UUID.randomUUID(), "Jane", "Doe");

		return args -> studentRepository.saveAll(Arrays.asList(defaultStudent1, defaultStudent2));
	}

//	@Bean
//	public ApplicationRunner initUsers(){
//		final User defaultUser1 = new User(UUID.randomUUID().toString(), UUID.randomUUID().toString());
//		final User defaultUser2 = new User(UUID.randomUUID().toString(), UUID.randomUUID().toString());
//
//		return args -> userRepository.saveAll(Arrays.asList(defaultUser1, defaultUser2));
//	}
}
