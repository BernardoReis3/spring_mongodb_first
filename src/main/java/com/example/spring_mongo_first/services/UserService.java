package com.example.spring_mongo_first.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_mongo_first.domain.User;
import com.example.spring_mongo_first.dto.UserDTO;
import com.example.spring_mongo_first.repository.UserRepository;
import com.example.spring_mongo_first.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return userRepo.insert(user);
	}
	
	//fromDTO is DTO logic, however, if user is from DB then we already have a userRepo. instantiated
	public User fromDTO(UserDTO uDTO) {
		return new User(uDTO.getId(), uDTO.getName(), uDTO.getEmail());
	}
	
	public void deleteById(String id) {
		findById(id);
		userRepo.deleteById(id);
	}

}
