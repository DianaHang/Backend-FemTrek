package com.femtrek.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.femtrek.models.User;
import com.femtrek.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//GET 
		@GetMapping
		public List<User> getAllUsers(){
			return userService.findAllUsers();
		}
		
				@GetMapping("{id}")
				public ResponseEntity<User> getuserById(@PathVariable Long id){
					return userService.findUserById(id)
							.map(ResponseEntity::ok)
							.orElse(ResponseEntity.notFound().build());
				}
				
				// POST
				@PostMapping
				public User createuser (@RequestBody User user) {
					return userService.saveUser(user);
				}

				
				//PUT
				
				@PutMapping("/quizzs/{id}")
			    public User updateuser(@PathVariable Long id, @RequestBody User userDetails) {
			        return userService.updateUser(id, userDetails);
			    }

				
				// DELETE
				@DeleteMapping("{id}")
				public ResponseEntity<Void> deleteuser(@PathVariable Long id){
					return userService.findUserById(id)
							.map(user -> { userService.deleteuserById(id); return ResponseEntity.ok().<Void>build();})
							.orElse(ResponseEntity.notFound().build());
				}
	
	

}
