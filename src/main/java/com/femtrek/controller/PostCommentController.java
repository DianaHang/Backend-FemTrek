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

import com.femtrek.models.PostComment;
import com.femtrek.services.PostCommentService;

@RestController
@RequestMapping("/api/post_comments")
public class PostCommentController {
	private PostCommentService postCommentService;
	
	//GET 
			@GetMapping
			public List<PostComment> getAllposts(){
				return postCommentService.findAllPostsComments();
			}
			
			@GetMapping("{id}")
			public ResponseEntity<PostComment> getpostById(@PathVariable Long id){
				return postCommentService.findPostCommentById(id)
						.map(ResponseEntity::ok)
						.orElse(ResponseEntity.notFound().build());
			}
			
			// POST
			@PostMapping
			public PostComment createpost (@RequestBody PostComment postComment) {
				return postCommentService.savePostComment(postComment);
			}

			
			//PUT
			
			@PutMapping("/post_comments/{id}")
		    public PostComment updatepost(@PathVariable Long id, @RequestBody PostComment postCommentDetails) {
		        return postCommentService.updatePostComment(id, postCommentDetails);
		    }

			
			// DELETE
			@DeleteMapping("{id}")
			public ResponseEntity<Void> deletepost(@PathVariable Long id){
				return postCommentService.findPostCommentById(id)
						.map(post -> { postCommentService.deletepostById(id); return ResponseEntity.ok().<Void>build();})
						.orElse(ResponseEntity.notFound().build());
			}

}
