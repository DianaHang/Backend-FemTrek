package com.femtrek.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.femtrek.models.Profile;
import com.femtrek.services.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	private ProfileService profileService;
	
	//GET 
	@GetMapping
	public List<Profile> getAllposts(){
		return profileService.findAllProfiles();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Profile> getpostById(@PathVariable Long id){
		return profileService.findProfileById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public Profile createpost (@RequestBody Profile profile) {
		return profileService.saveProfile(profile);
	}

	
	//PUT
	
	@PutMapping("/post_comments/{id}")
    public Profile updatepost(@PathVariable Long id, @RequestBody Profile profileDetails) {
        return profileService.updateprofile(id, profileDetails);
    }

	
	// DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletepost(@PathVariable Long id){
		return profileService.findProfileById(id)
				.map(post -> { profileService.deleteprofileById(id); return ResponseEntity.ok().<Void>build();})
				.orElse(ResponseEntity.notFound().build());
	}

}
