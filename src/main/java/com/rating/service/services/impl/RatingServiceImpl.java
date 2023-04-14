package com.rating.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.entities.Rating;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.services.RatingService;


@Service
public class RatingServiceImpl implements RatingService{

	
	private Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating create(Rating rating) {
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		logger.info("findUserDetailsById-Id=");
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		logger.info("findUserDetailsById-Id=" + hotelId);
		return ratingRepository.findByHotelId(hotelId);
	}

}
