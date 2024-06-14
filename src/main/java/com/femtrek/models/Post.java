package com.femtrek.models;

import java.time.LocalDate;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	//Valor único
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			
			//Columnas de la tabla
				@Column(name="post_id")
				private int post_id;
			
			@Column(name="post_content", nullable=false)
			private String post_content;
			
			@Column(name="post_tags", nullable=false, length=255)
			private String post_tags;
			
			@Column(name="post_type", nullable=false, length=45)
			private String post_type;
			
			@Column(name="likes_count", nullable=false)
			private int likes_count;
			
			@Column(name="comment_count", nullable=false)
			private int comment_count;
			
			@Column(name="post_status", nullable=false, length=20)
			private String post_status;
			
			@Column(name="created_date", nullable=false)
			private LocalDate created_date;
			
			@Column(name="update_date", nullable=false)
			private LocalDate update_date;
			
			//Relaciones
			@OneToMany (mappedBy = "post")
			private Set<PostComment> postComment;
			

			@ManyToOne
			@JoinColumn(name="user_id", nullable=false)
			private User user;
			
			@OneToOne
		    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
		    private Location location;
			
			
			/*Constructor global*/
			public Post() {
				super();
			}

			/*Constructor con campos*/
			public Post(int post_id, String post_content, String post_tags, String post_type, int likes_count,
					int comment_count, String post_status, LocalDate created_date, LocalDate update_date,
					Set<PostComment> postComment, User user, Location location) {
				super();
				this.post_id = post_id;
				this.post_content = post_content;
				this.post_tags = post_tags;
				this.post_type = post_type;
				this.likes_count = likes_count;
				this.comment_count = comment_count;
				this.post_status = post_status;
				this.created_date = created_date;
				this.update_date = update_date;
				this.postComment = postComment;
				this.user = user;
				this.location = location;
			}
			
			
			/*Getter y Setters*/
			public int getPost_id() {
				return post_id;
			}

			public void setPost_id(int post_id) {
				this.post_id = post_id;
			}


			public String getPost_content() {
				return post_content;
			}

			public void setPost_content(String post_content) {
				this.post_content = post_content;
			}

			public String getPost_tags() {
				return post_tags;
			}

			public void setPost_tags(String post_tags) {
				this.post_tags = post_tags;
			}

			public String getPost_type() {
				return post_type;
			}

			public void setPost_type(String post_type) {
				this.post_type = post_type;
			}

			public int getLikes_count() {
				return likes_count;
			}

			public void setLikes_count(int likes_count) {
				this.likes_count = likes_count;
			}

			public int getComment_count() {
				return comment_count;
			}

			public void setComment_count(int comment_count) {
				this.comment_count = comment_count;
			}

			public String getPost_status() {
				return post_status;
			}

			public void setPost_status(String post_status) {
				this.post_status = post_status;
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
			

			public Set<PostComment> getPostComment() {
				return postComment;
			}

			public void setPostComment(Set<PostComment> postComment) {
				this.postComment = postComment;
			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

			public Location getLocation() {
				return location;
			}

			public void setLocation(Location location) {
				this.location = location;
			}

			/*To String*/
			@Override
			public String toString() {
				return "Post [post_id=" + post_id + ", post_content=" + post_content + ", post_tags=" + post_tags
						+ ", post_type=" + post_type + ", likes_count=" + likes_count + ", comment_count="
						+ comment_count + ", post_status=" + post_status + ", created_date=" + created_date
						+ ", update_date=" + update_date + ", postComment=" + postComment 
						+ ", user=" + user + ", location=" + location + "]";
			}	
}
