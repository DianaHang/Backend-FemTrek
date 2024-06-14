package com.femtrek.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.femtrek.models.Post;
import com.femtrek.repositories.PostRepository;


@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	
	//GET ALL
	public List<Post> findAllPosts(){
		return postRepository.findAll();
	}
	
	//Get sólo un post
	public Optional<Post> findPostById(Long id){
		return postRepository.findById(id);
	}
	
	//POST
	public Post savePost (Post post) {
		return postRepository.save(post);
	}

	// PUT
    public Post updatePost(Long id, Post postDetails) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.setPost_content(postDetails.getPost_content());
            postToUpdate.setPost_tags(postDetails.getPost_tags());
            postToUpdate.setPost_type(postDetails.getPost_type());
            postToUpdate.setPost_status(postDetails.getPost_status());
            
            //Preguntar si es correcto en los servicios poder cambiar la localización
            postToUpdate.setLocation(postDetails.getLocation());
            
            return postRepository.save(postToUpdate);
        } else {
            throw new RuntimeException("post not found with id " + id);
        }
    }
	
	//DELETE
	public void deletepostById(Long id) {
		postRepository.deleteById(id);
	}
	

	
}
