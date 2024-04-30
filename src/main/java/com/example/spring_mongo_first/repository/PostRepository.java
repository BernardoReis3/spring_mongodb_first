package com.example.spring_mongo_first.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_mongo_first.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//to be case insensitive and ignore case use method findByTitleContainingIgnoreCase
	List<Post> findByTitleContaining(String text);
}
