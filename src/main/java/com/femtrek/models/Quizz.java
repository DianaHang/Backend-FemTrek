package com.femtrek.models;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="quizz")
public class Quizz {


	//Valor único
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="quizz_id")
		private int quizz_id;
	
		
		/*Preguntar como se manejaría el set para los datos de latin_countries_of_interest y travel_style 
		 * y ENUM para travel_preference*/
		
		@Column (name="travel_excitement")
		private String travel_excitement;
		
		@Column (name="favorite_season")
		private String favorite_season;
		
		@Column (name="travel_enjoy")
		private String travel_enjoy;
		
		@Column(name="created_at")
		private LocalDate created_at;
		
		@Column(name="travel_preference")
	    private String travel_preference;
		                                      
		@Column(name="travel_style")
	    private String travel_style;

		
		//Columnas Set
		@Column(name="latin_countries_of_interest")
	    private String latin_countries_of_interest;
		
				
		//Relaciones con User
		@OneToOne
	    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	    private User user;
		
		
	    //Super constructor
		public Quizz() {
			super();
		}

		
		
		//Usando campos
		public Quizz(int quizz_id, String travel_excitement, String favorite_season, String travel_enjoy,
				LocalDate created_at, String travel_preference, String travel_style, String latin_countries_of_interest,
				User user) {
			super();
			this.quizz_id = quizz_id;
			this.travel_excitement = travel_excitement;
			this.favorite_season = favorite_season;
			this.travel_enjoy = travel_enjoy;
			this.created_at = created_at;
			this.travel_preference = travel_preference;
			this.travel_style = travel_style;
			this.latin_countries_of_interest = latin_countries_of_interest;
			this.user = user;
		}


		//Getters y setter
		public int getQuizz_id() {
			return quizz_id;
		}


		public void setQuizz_id(int quizz_id) {
			this.quizz_id = quizz_id;
		}


		public String getTravel_excitement() {
			return travel_excitement;
		}



		public void setTravel_excitement(String travel_excitement) {
			this.travel_excitement = travel_excitement;
		}



		public String getFavorite_season() {
			return favorite_season;
		}



		public void setFavorite_season(String favorite_season) {
			this.favorite_season = favorite_season;
		}



		public String getTravel_enjoy() {
			return travel_enjoy;
		}



		public void setTravel_enjoy(String travel_enjoy) {
			this.travel_enjoy = travel_enjoy;
		}



		public LocalDate getCreated_at() {
			return created_at;
		}



		public void setCreated_at(LocalDate created_at) {
			this.created_at = created_at;
		}



		public String getTravel_preference() {
			return travel_preference;
		}



		public void setTravel_preference(String travel_preference) {
			this.travel_preference = travel_preference;
		}



		public String getTravel_style() {
			return travel_style;
		}



		public void setTravel_style(String travel_style) {
			this.travel_style = travel_style;
		}



		public User getUser() {
			return user;
		}



		public void setUser(User user) {
			this.user = user;
		}



		/*Getter and Setter - para los Set*/
		public Set<String> getLatinCountriesOfInterest() {
	        if (latin_countries_of_interest == null || latin_countries_of_interest.isEmpty()) {
	            return new HashSet<>();
	        }
	        return Arrays.stream(latin_countries_of_interest.split(","))
	                     .collect(Collectors.toSet());
	    }

	    public void setLatinCountriesOfInterest(Set<String> latinCountriesOfInterest) {
	        if (latinCountriesOfInterest == null || latinCountriesOfInterest.isEmpty()) {
	            this.latin_countries_of_interest = "";
	        } else {
	            this.latin_countries_of_interest = String.join(",", latinCountriesOfInterest);
	        }
	    }


		//ToString

		@Override
		public String toString() {
			return "Quizz [quizz_id=" + quizz_id + ", travel_excitement=" + travel_excitement + ", favorite_season="
					+ favorite_season + ", travel_enjoy=" + travel_enjoy + ", created_at=" + created_at
					+ ", travel_preference=" + travel_preference + ", travel_style=" + travel_style
					+ ", latin_countries_of_interest=" + latin_countries_of_interest + ", user=" + user + "]";
		}
	    
	    
		

	
		
	    		
	
		
		
	    
	    
	    
		
		
		
		
}
