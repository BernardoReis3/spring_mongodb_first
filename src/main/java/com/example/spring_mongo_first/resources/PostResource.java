package com.example.spring_mongo_first.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_mongo_first.domain.Post;
import com.example.spring_mongo_first.resources.util.EncodeURL;
import com.example.spring_mongo_first.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);	
		return ResponseEntity.ok().body(post);
	}	
	
	@GetMapping(value = "/titlefilter")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
		text = EncodeURL.decodeURL(text);
		List<Post> posts = postService.findByTitle(text);
		return ResponseEntity.ok().body(posts);
		
	}
	
	@GetMapping(value = "/textfullsearch")
	public ResponseEntity<List<Post>> findTextByDate(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "beginDate", defaultValue = "") String beginDate,
			@RequestParam(value = "endDate", defaultValue = "") String endDate){
		text = EncodeURL.decodeURL(text);
		Date begin = EncodeURL.convertDate(beginDate, new Date(0L));
		Date end = EncodeURL.convertDate(endDate, new Date());
		List<Post> posts = postService.searchTextByDate(text, begin, end);
		return ResponseEntity.ok().body(posts);
		
	}
	
}
