package com.sanjay.template.controller;


import com.sanjay.template.model.User;
import com.sanjay.template.repository.MyApplicationRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class MyApplicationController {

	private MyApplicationRepository myApplicationRepository;

	/*Read this why constructor injection is preferred compared to autowiring - https://www.baeldung.com/constructor-injection-in-spring*/
	public MyApplicationController(MyApplicationRepository myApplicationRepository) {
		this.myApplicationRepository = myApplicationRepository;
	}

	@GetMapping
	public ResponseEntity getAllUsers(){
		return new ResponseEntity(myApplicationRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity createUser(@RequestBody User  user){
		myApplicationRepository.save(User.builder().firstName(user.getFirstName()).
				lastName(user.getLastName())
				.email(user.getEmail()).build());
		return new ResponseEntity("User Created", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity updateUser(User user){
		return new ResponseEntity("User Updated users", HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity deteleUser(@PathVariable("userId") String userId){
		myApplicationRepository.deleteById(userId);
		return new ResponseEntity("User deleted", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity deleteAllUsers(){
		myApplicationRepository.deleteAll();
		return new ResponseEntity("User deleted", HttpStatus.OK);
	}

}
