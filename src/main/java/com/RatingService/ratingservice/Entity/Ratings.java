package com.RatingService.ratingservice.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Ratings {

	
	
	private int ratingid;
	private int rating;
	private String feedback;
	private int bookid;
	
}
