package com.femtrek.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="location")
public class Location {

	//Valor único
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="location_id")
		private int location_id;
		
		@Column(name="country", nullable=false, length=50)
		private String country;
		
		@Column(name="city", nullable=false, length=50)
		private String city;

		
		//Relaciones
		@OneToOne
	    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
	    private Post post;
		
		@OneToOne
	    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	    private User user;
		
		//Constructor vacío
		public Location() {
			super();
		}

		//Constructor con campos
		public Location(int location_id, String country, String city, Post post, User user) {
			super();
			this.location_id = location_id;
			this.country = country;
			this.city = city;
			this.post = post;
			this.user = user;
		}
		
		//Getters y Setters
		public int getLocation_id() {
			return location_id;
		}

		public void setLocation_id(int location_id) {
			this.location_id = location_id;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		//G&S para relacion
		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		//To String
		@Override
		public String toString() {
			return "Location [location_id=" + location_id + ", country=" + country + ", city=" + city + ", post=" + post
					+ ", user=" + user + "]";
		}
		
}
