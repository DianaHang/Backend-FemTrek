package com.femtrek.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="user_information")

public class User {
	
	//Valor único
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//Columnas de la tabla
		@Column(name="user_id")
		private int user_id;
		
		@Column(name="first_name", nullable=false, length=45)
		private String first_name;
		
		@Column(name="last_name", nullable=false, length=45)
		private String last_name;
		
		@Column(name="user_name", nullable=false, length=45)
		private String user_name;
		
		@Column(name="user_email", nullable=false, length=45)
		private String user_email;
		
		@Column(name="login_password", nullable=false, length=45)
		private String login_password;
		
		@Column(name="user_cellphone", nullable=false, length=45)
		private int user_cellphone;
		
		@Column(name="user_birthday", nullable=false)
		private LocalDate user_birthday;
		
		@Column(name="created_at", nullable=false)
		private LocalDate created_at;
		
		@Column(name="update_at", nullable=false)
		private LocalDate update_at;
		
		
		
				
		//Relaciones
		@OneToMany (mappedBy = "user")
		private Set<Post> post;
		
		@OneToOne
	    @JoinColumn(name = "quizz_id", referencedColumnName = "quizz_id")
	    private Quizz quizz;
		
		@OneToOne
	    @JoinColumn(name = "user_information_user_id", referencedColumnName = "user_information_user_id")
	    private Followers followers;
		
		@OneToOne
	    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
	    private Profile profile;
		
		@OneToOne
	    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
	    private Location location;

		/*Constructor global*/
		public User() {
			super();
		}

		/*Constructor con campos*/
		public User(int user_id, String first_name, String last_name, String user_name, String user_email,
				String login_password, int user_cellphone, LocalDate user_birthday, LocalDate created_at,
				LocalDate update_at, Set<Post> post, Quizz quizz, Followers followers, Profile profile,
				Location location) {
			super();
			this.user_id = user_id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.user_name = user_name;
			this.user_email = user_email;
			this.login_password = login_password;
			this.user_cellphone = user_cellphone;
			this.user_birthday = user_birthday;
			this.created_at = created_at;
			this.update_at = update_at;
			this.post = post;
			this.quizz = quizz;
			this.followers = followers;
			this.profile = profile;
			this.location = location;
		}

		/*Getter y Setters*/
		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getUser_email() {
			return user_email;
		}

		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}

		public String getLogin_password() {
			return login_password;
		}

		public void setLogin_password(String login_password) {
			this.login_password = login_password;
		}

		public int getUser_cellphone() {
			return user_cellphone;
		}

		public void setUser_cellphone(int user_cellphone) {
			this.user_cellphone = user_cellphone;
		}

		public LocalDate getUser_birthday() {
			return user_birthday;
		}

		public void setUser_birthday(LocalDate user_birthday) {
			this.user_birthday = user_birthday;
		}

		public LocalDate getCreated_at() {
			return created_at;
		}

		public void setCreated_at(LocalDate created_at) {
			this.created_at = created_at;
		}

		public LocalDate getUpdate_at() {
			return update_at;
		}

		public void setUpdate_at(LocalDate update_at) {
			this.update_at = update_at;
		}

		public Set<Post> getPost() {
			return post;
		}

		public void setPost(Set<Post> post) {
			this.post = post;
		}

		public Quizz getQuizz() {
			return quizz;
		}

		public void setQuizz(Quizz quizz) {
			this.quizz = quizz;
		}

		public Followers getFollowers() {
			return followers;
		}

		public void setFollowers(Followers followers) {
			this.followers = followers;
		}

		public Profile getProfile() {
			return profile;
		}

		public void setProfile(Profile profile) {
			this.profile = profile;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		//To String
		@Override
		public String toString() {
			return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name
					+ ", user_name=" + user_name + ", user_email=" + user_email + ", login_password=" + login_password
					+ ", user_cellphone=" + user_cellphone + ", user_birthday=" + user_birthday + ", created_at="
					+ created_at + ", update_at=" + update_at + ", post=" + post + ", quizz=" + quizz + ", followers="
					+ followers + ", profile=" + profile + ", location=" + location + "]";
		}
		
		
		
		
		
	/*
	 * Anotaciones
	 * */	
		
		
		
}
