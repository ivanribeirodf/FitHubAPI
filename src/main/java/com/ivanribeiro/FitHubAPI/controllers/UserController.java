package com.ivanribeiro.FitHubAPI.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivanribeiro.FitHubAPI.dtos.UserRecordDto;
import com.ivanribeiro.FitHubAPI.models.UserModel;
import com.ivanribeiro.FitHubAPI.repositories.UserRepository;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/users")
	public ResponseEntity<UserModel> saveProduct(@RequestBody @Valid UserRecordDto userRecordDto) {
		var userModel = new UserModel();
		BeanUtils.copyProperties(userRecordDto, userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> getAllUsers() {
//		List<UserModel> userList = userRepository.findAll();		
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id) {
		Optional<UserModel> user0 = userRepository.findById(id);
		if (user0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(user0.get());
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid UserRecordDto userRecordDto) {
		Optional<UserModel> user0 = userRepository.findById(id);
		if (user0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		var userModel = user0.get();
		BeanUtils.copyProperties(userRecordDto, userModel);
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userModel));
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id) {
		Optional<UserModel> user0 = userRepository.findById(id);
		if (user0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		userRepository.delete(user0.get());
		return ResponseEntity.status(HttpStatus.OK).body("User deleted sucessfully!");
	}

}
