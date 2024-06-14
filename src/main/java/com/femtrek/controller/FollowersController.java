package com.femtrek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femtrek.models.Followers;
import com.femtrek.services.FollowersService;


@RestController
@RequestMapping("/api/followers")
public class FollowersController {
	@Autowired
	private FollowersService followersService;
	
	//GET

	@GetMapping
	public List<Followers> getAllLocations(){
		return followersService.findAllFollowers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Followers> getlfollowersById(@PathVariable Long id){
		return followersService.findFollowersById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
// POST
		@PostMapping
		public Followers createfollowers (@RequestBody Followers followers) {
			return followersService.savefollowers(followers);
		}

	
	
		// DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletelocation(@PathVariable Long id){
		return followersService.findFollowersById(id)
				.map(location -> { followersService.deletefollowersById(id); return ResponseEntity.ok().<Void>build();})
				.orElse(ResponseEntity.notFound().build());
	}

}
