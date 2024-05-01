package com.example.spring_mongo_first.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.spring_mongo_first.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//to be case insensitive and ignore case use method findByTitleContainingIgnoreCase
	List<Post> findByTitleContaining(String text);
	
	//to be case insensitive and ignore case use { 'title': { $regex: ?0, $options: 'i' } }
	@Query("{ 'title': { $regex: ?0 } }")
	List<Post> findByTitleFilter(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> searchTextByDate(String text, Date beginDate, Date endDate);
	
}
