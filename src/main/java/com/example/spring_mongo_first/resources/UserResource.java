package com.example.spring_mongo_first.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_mongo_first.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User john = new User("1", "John Caine", "john.c@gmail.com");
		User elena = new User("2", "Elena Davidson", "elena.d@gmail.com");
		
		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(john, elena));
		
		return ResponseEntity.ok().body(users);
	}

}
