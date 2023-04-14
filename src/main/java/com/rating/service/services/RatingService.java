package com.rating.service.services;

import java.util.List;

import com.rating.service.entities.Rating;

public interface RatingService {

	List<Rating> getAllRatings();

	Rating create(Rating rating);

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);
}
