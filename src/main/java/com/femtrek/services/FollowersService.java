package com.femtrek.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.femtrek.models.Followers;
import com.femtrek.repositories.FollowersRepository;

@Service
public class FollowersService {

    @Autowired
    private FollowersRepository followersRepository;

   		
  		//Get sólo un location
    
		    public List<Followers> findAllFollowers(){
				return followersRepository.findAll();
			}
    
			public Optional<Followers> findFollowersById(Long id){
				return followersRepository.findById(id);
			}
  		
  		//POST
  		public Followers savefollowers (Followers followers) {
  			return followersRepository.save(followers);
  		}

  		
  		//DELETE
  		public void deletefollowersById(Long id) {
  			followersRepository.deleteById(id);
  		}
}

