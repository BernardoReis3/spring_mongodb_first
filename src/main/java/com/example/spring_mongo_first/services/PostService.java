package com.example.spring_mongo_first.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_mongo_first.domain.Post;
import com.example.spring_mongo_first.repository.PostRepository;
import com.example.spring_mongo_first.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository userRepo;	
	
	public Post findById(String id) {
		Optional<Post> post = userRepo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	

}
