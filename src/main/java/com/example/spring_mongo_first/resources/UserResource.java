package com.example.spring_mongo_first.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.spring_mongo_first.domain.User;
import com.example.spring_mongo_first.dto.UserDTO;
import com.example.spring_mongo_first.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){		
		List<User> users = userService.findAll();	
		List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(usersDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userService.findById(id);	
		UserDTO userDTO = new UserDTO(user);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
		User user = userService.fromDTO(userDTO);	
		user = userService.insert(user);
		URI uriInsert = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uriInsert).build();
	}
}
