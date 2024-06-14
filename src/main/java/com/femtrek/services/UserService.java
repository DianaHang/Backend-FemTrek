package com.femtrek.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.femtrek.models.User;
import com.femtrek.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

		
		//Get sólo un post
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
		public Optional<User> findUserById(Long id){
			return userRepository.findById(id);
		}
		
		//POST
		public User saveUser (User user) {
			return userRepository.save(user);
		}

		// PUT
	    public User updateUser(Long id, User userDetails) {
	        Optional<User> optionalUser = userRepository.findById(id);
	        if (optionalUser.isPresent()) {
	            User userToUpdate = optionalUser.get();
	            userToUpdate.setFirst_name(userDetails.getFirst_name());
	            userToUpdate.setLast_name(userDetails.getLast_name());
	            userToUpdate.setUser_name(userDetails.getUser_name());
	            userToUpdate.setUser_email(userDetails.getUser_email());
	            userToUpdate.setLogin_password(userDetails.getLogin_password());
	            userToUpdate.setUser_cellphone(userDetails.getUser_cellphone());
	            userToUpdate.setUser_birthday(userDetails.getUser_birthday());
	            
	            //Preguntar si es correcto en los servicios poder cambiar la localización
	            userToUpdate.setLocation(userDetails.getLocation());
	            
	            return userRepository.save(userToUpdate);
	        } else {
	            throw new RuntimeException("post not found with id " + id);
	        }
	    }
		
		//DELETE
		public void deleteuserById(Long id) {
			userRepository.deleteById(id);
		}
	
}
