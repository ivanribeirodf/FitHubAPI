package com.ivanribeiro.FitHubAPI.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ivanribeiro.FitHubAPI.UserRole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDto(
		
		@NotBlank
		String 		user_name,
		
		@NotNull
		LocalDate	user_dtnasc,
		
		@NotBlank
		String		user_address,
		
		@NotBlank
		String 		user_email,
		
		@NotBlank
		String 		user_password,
		
		UserRole user_role,
		
		@NotNull
		String 		user_phone,
	
		LocalDateTime 	created_at,
	
		LocalDate		update_at
		
		) {

}
