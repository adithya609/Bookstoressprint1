package com.cg.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.UserClass;
import com.cg.bookstore.exception.UserNotFoundException;
import com.cg.bookstore.service.ILoginService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	ILoginService iLoginService;

	
	@PostMapping(path="/addUser")
	  public ResponseEntity<UserClass> addUser(@RequestBody UserClass login)
	  {
		  Optional<UserClass> optional=iLoginService.addUser(login);
		  return new ResponseEntity<UserClass>(optional.get(),HttpStatus.OK); 
	  }

	
	@DeleteMapping(path="/removeUser")
	  public ResponseEntity<List<UserClass>> removeUser(@RequestBody UserClass login)
	  {
		List<UserClass> list=iLoginService.removeUser(login);
		return new ResponseEntity<List<UserClass>>(list,HttpStatus.OK);
	  }
	
	
	
	@GetMapping("/validateUser/{userId}/{password}")
	public UserClass validateUser(@PathVariable Integer userId, @PathVariable String password) 
	{
		return iLoginService.validateUser(userId,password);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*	
	@GetMapping("/getall")
	List<UserClass> getUser() {
		return userRepository.findAll();
	}
	
	// To create/INSERT new Student into database
	@PostMapping("/insertnew")
	UserClass insertUser(@RequestBody UserClass userClass) {
		return userRepository.save(userClass);
	}
	
	// To search Student by Id
	@GetMapping("/{id}")
	public UserClass getUserById(@PathVariable Integer id) {
		return userRepository.findById(id).get();
		
	}
	
	// To Update student existing record
	//@PutMapping("/{id}")
	//public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		//Student existingStudent = studentReprosotry.findById(id).get();
		//BeanUtils.copyProperties(student, existingStudent, "id");
		//return studentReprosotry.save(existingStudent);
	//}
	
	//To Delete Student 
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	
	
	*/
}
