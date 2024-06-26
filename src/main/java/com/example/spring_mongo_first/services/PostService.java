package com.example.spring_mongo_first.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_mongo_first.domain.Post;
import com.example.spring_mongo_first.repository.PostRepository;
import com.example.spring_mongo_first.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;	
	
	public Post findById(String id) {
		Optional<Post> post = postRepo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return postRepo.findByTitleFilter(text);
	}
	
	public List<Post> searchTextByDate(String text, Date beginDate, Date endDate){
		endDate = new Date(endDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepo.searchTextByDate(text, beginDate, endDate);
	}

}
