package com.femtrek.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.femtrek.models.PostComment;
import com.femtrek.repositories.PostCommentRepository;


@Service
public class PostCommentService {
	@Autowired
	private PostCommentRepository postCommentRepository;
	
	//GET ALL
		public List<PostComment> findAllPostsComments(){
			return postCommentRepository.findAll();
		}
		
		//Get sólo un post
		public Optional<PostComment> findPostCommentById(Long id){
			return postCommentRepository.findById(id);
		}
		
		//POST
		public PostComment savePostComment (PostComment postComment) {
			return postCommentRepository.save(postComment);
		}

		// PUT
	    public PostComment updatePostComment(Long id, PostComment postCommentDetails) {
	        Optional<PostComment> optionalPostComment = postCommentRepository.findById(id);
	        if (optionalPostComment.isPresent()) {
	            PostComment postCommentToUpdate = optionalPostComment.get();
	            postCommentToUpdate.setComment_content(postCommentDetails.getComment_content());
	            postCommentToUpdate.setUpdate_date(postCommentDetails.getUpdate_date());	            
	            return postCommentRepository.save(postCommentToUpdate);
	        } else {
	            throw new RuntimeException("post not found with id " + id);
	        }
	    }
		
		//DELETE
		public void deletepostById(Long id) {
			postCommentRepository.deleteById(id);
		}
		

}
