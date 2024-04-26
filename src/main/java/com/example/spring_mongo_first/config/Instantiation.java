package com.example.spring_mongo_first.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.spring_mongo_first.domain.Post;
import com.example.spring_mongo_first.domain.User;
import com.example.spring_mongo_first.repository.PostRepository;
import com.example.spring_mongo_first.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, "Trip to Brasil", "I am going to Brasil next week!", sdf.parse("2023/02/24"), maria);
		Post post2 = new Post(null, "Good morning", "Wish a great day for everyone", sdf.parse("2023/07/08"), maria);
		userRepo.saveAll(Arrays.asList(maria, alex, bob));
		postRepo.saveAll(Arrays.asList(post1, post2));
	}

}
