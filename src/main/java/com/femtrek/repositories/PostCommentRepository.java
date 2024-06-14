package com.femtrek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.femtrek.models.PostComment;

@Repository
public interface PostCommentRepository extends JpaRepository <PostComment, Long>{
	

}
