package com.femtrek.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.femtrek.models.Profile;
import com.femtrek.repositories.ProfileRepository;

@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	
	//GET ALL
			public List<Profile> findAllProfiles(){
				return profileRepository.findAll();
			}
			
			//Get sólo un post
			public Optional<Profile> findProfileById(Long id){
				return profileRepository.findById(id);
			}
			
			//POST
			public Profile saveProfile (Profile profile) {
				return profileRepository.save(profile);
			}

			// PUT
		    public Profile updateprofile(Long id, Profile profileDetails) {
		        Optional<Profile> optionalprofile = profileRepository.findById(id);
		        if (optionalprofile.isPresent()) {
		            Profile profileToUpdate = optionalprofile.get();
		            profileToUpdate.setDescription(profileDetails.getDescription());
		            profileToUpdate.setProfile_photo(profileDetails.getProfile_photo());
		            profileToUpdate.setCover_photo(profileDetails.getCover_photo());
		            return profileRepository.save(profileToUpdate);
		        } else {
		            throw new RuntimeException("post not found with id " + id);
		        }
		    }
			
			//DELETE
			public void deleteprofileById(Long id) {
				profileRepository.deleteById(id);
			}

}
