package com.RatingService.ratingservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ratingConfig {
	
	
	
	
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception
	{
		
		
		http.authorizeHttpRequests().anyRequest().authenticated().and().oauth2ResourceServer().jwt();
		return http.build();
	}

}
