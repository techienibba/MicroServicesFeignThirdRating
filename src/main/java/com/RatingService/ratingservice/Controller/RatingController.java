package com.RatingService.ratingservice.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RatingService.ratingservice.Entity.Ratings;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	
	Ratings rating1;
	Ratings rating2;
	Ratings rating3;
	List<Ratings> ratinglist;
	
	@GetMapping
	@PreAuthorize("hasRole='ADMIN'")
	public List<Ratings> getratings()
	{
		rating1 = new Ratings();
		rating1.setRatingid(1);
		rating1.setRating(9);
		rating1.setFeedback("Amazing Book");
		
		rating2 = new Ratings();
		rating2.setRatingid(2);
		rating2.setRating(5);
		rating2.setFeedback("Average Book");
		
		rating3 = new Ratings();
		rating3.setRatingid(3);
		rating3.setRating(1);
		rating3.setFeedback("Lacklustre Book");
		ratinglist = new ArrayList<>();
		ratinglist.add(rating1);
		ratinglist.add(rating2);
		ratinglist.add(rating3);
		
		return ratinglist;
		
		
		
		
	}
	
	@GetMapping("/{ratingid}")
	@PreAuthorize("hasRole='ADMIN'||hasRole='USER'")
	public Ratings getratingbyid(@PathVariable("ratingid") int ratingid)
	{
		rating1 = new Ratings();
		rating1.setRatingid(1);
		rating1.setRating(9);
		rating1.setBookid(1);
		rating1.setFeedback("Amazing Book");
		
		rating2 = new Ratings();
		rating2.setRatingid(2);
		rating2.setBookid(2);
		rating2.setRating(5);
		rating2.setFeedback("Average Book");
		
		rating3 = new Ratings();
		rating3.setRatingid(3);
		rating3.setRating(1);
		rating3.setBookid(2);
		rating3.setFeedback("Lacklustre Book");
		ratinglist = new ArrayList<>();
		ratinglist.add(rating1);
		ratinglist.add(rating2);
		ratinglist.add(rating3);
		
		Ratings ratingfound=ratinglist.stream().filter(e -> e.getRatingid()==ratingid).findAny().get();
	
		return ratingfound;
	}
	

}
