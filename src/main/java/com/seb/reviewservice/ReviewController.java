package com.seb.reviewservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import com.seb.db.ReviewEntityDummyData;
import com.seb.db.ReviewRepository;
import com.seb.entities.ReviewEntity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/review-service")
public class ReviewController {

	@Autowired
	private Environment env;
	
	@Autowired
	private ReviewRepository reviews;
	
	@PostConstruct
	private void loadDummyData() {
		
		reviews.saveAll(ReviewEntityDummyData.data);
	}

		
	



	@GetMapping("/title/{title}")
	public List<ReviewEntity> GetReviewsByTitle(@PathVariable(value = "title") String title) {
		
			
		return new ArrayList<ReviewEntity>((Collection<? extends ReviewEntity>) reviews.findByTitle(title.replace('+', ' '))); 

	}
	
	
	@GetMapping("/id/{id}")
	public List<ReviewEntity> GetReviewsById(@PathVariable(value = "id") String id) {
		
			
		return new ArrayList<ReviewEntity>((Collection<? extends ReviewEntity>) reviews.findByImbdId(id)); 

	}
	
	
	@PostMapping
	public ResponseEntity<ReviewEntity> PostReview(@RequestBody ReviewEntity entity) {
		
		try {
			reviews.save(entity);			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();
	}



}
