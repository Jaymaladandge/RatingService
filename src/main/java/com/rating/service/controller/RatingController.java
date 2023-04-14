package com.rating.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {

	private Logger logger = LoggerFactory.getLogger(RatingController.class);
	
	@Autowired
	private RatingService ratingService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		Rating rating2 = ratingService.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating2);
	}
	
	
	@PostMapping
	public ResponseEntity<List<Rating>> getRatings(){
		List<Rating> ratings = ratingService.getAllRatings();
		return ResponseEntity.ok(ratings);
	}
	
	
	@GetMapping("users/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId){
		List<Rating> rating = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok().body(rating);
	}
	
	
	@GetMapping("hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId){
		List<Rating> rating = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(rating);
	}
	
	
}
