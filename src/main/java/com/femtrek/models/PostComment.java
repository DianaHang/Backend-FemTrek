package com.femtrek.models;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="post_comments")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//Columnas de la tabla
		@Column(name="comment_id")
		private int comment_id;
	
	@Column(name="comment_content", nullable=false)
	private String comment_content;
	
	@Column(name="created_date", nullable=false)
	private LocalDate created_date;
	
	@Column(name="update_date", nullable=false)
	private LocalDate update_date;
	
	
	//Relaciones
	@ManyToOne
	@JoinColumn(name="post_id", nullable=false)
	private Post post;


	//Constructor
	public PostComment() {
		super();
	}

	//Constructor
	public PostComment(int comment_id, String comment_content, LocalDate created_date, LocalDate update_date,
			Post post) {
		super();
		this.comment_id = comment_id;
		this.comment_content = comment_content;
		this.created_date = created_date;
		this.update_date = update_date;
		this.post = post;
	}

	//Getter y setters
	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public LocalDate getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(LocalDate update_date) {
		this.update_date = update_date;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	//To String
	@Override
	public String toString() {
		return "PostComment [comment_id=" + comment_id + ", comment_content=" + comment_content + ", created_date="
				+ created_date + ", update_date=" + update_date + ", post=" + post + "]";
	}
	
	
	
	
	
}
