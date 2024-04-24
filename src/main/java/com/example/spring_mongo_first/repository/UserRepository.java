package com.example.spring_mongo_first.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_mongo_first.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	

}
