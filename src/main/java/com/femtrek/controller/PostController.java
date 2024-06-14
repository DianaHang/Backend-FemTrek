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
import com.femtrek.models.Post;
import com.femtrek.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;

	//GET 
		@GetMapping
		public List<Post> getAllposts(){
			return postService.findAllPosts();
		}
		
		@GetMapping("{id}")
		public ResponseEntity<Post> getpostById(@PathVariable Long id){
			return postService.findPostById(id)
					.map(ResponseEntity::ok)
					.orElse(ResponseEntity.notFound().build());
		}
		
		// POST
		@PostMapping
		public Post createpost (@RequestBody Post post) {
			return postService.savePost(post);
		}

		
		//PUT
		
		@PutMapping("/posts/{id}")
	    public Post updatepost(@PathVariable Long id, @RequestBody Post postDetails) {
	        return postService.updatePost(id, postDetails);
	    }

		
		// DELETE
		@DeleteMapping("{id}")
		public ResponseEntity<Void> deletepost(@PathVariable Long id){
			return postService.findPostById(id)
					.map(post -> { postService.deletepostById(id); return ResponseEntity.ok().<Void>build();})
					.orElse(ResponseEntity.notFound().build());
		}
}
