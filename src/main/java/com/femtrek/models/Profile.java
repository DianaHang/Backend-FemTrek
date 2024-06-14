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
@Table(name="profile")
public class Profile {
	//Valor único
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Columnas de la tabla
	@Column(name="profile_id")
	private int profile_id;
	
	//Meter campo en Front End  en config. mi perfil
	@Column(name="description")
	private String description;
	
	//Se maneja con URL
	@Column(name="profile_photo")
	private String profile_photo;

	@Column(name="cover_photo")
	private String cover_photo;
	
	//Relaciones
	@OneToOne
    @JoinColumn(name = "quizz_id", referencedColumnName = "quizz_id")
    private Quizz quizz;
	
	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

	/*Constructor global*/
	public Profile() {
		super();
	}

	/*Constructor con campos*/
	public Profile(int profile_id, String description, String profile_photo, String cover_photo, Quizz quizz,
			User user) {
		super();
		this.profile_id = profile_id;
		this.description = description;
		this.profile_photo = profile_photo;
		this.cover_photo = cover_photo;
		this.quizz = quizz;
		this.user = user;
	}

	/*Getter y Setters*/
	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getCover_photo() {
		return cover_photo;
	}

	public void setCover_photo(String cover_photo) {
		this.cover_photo = cover_photo;
	}

	public Quizz getQuizz() {
		return quizz;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*To String*/
	@Override
	public String toString() {
		return "Profile [profile_id=" + profile_id + ", description=" + description + ", profile_photo=" + profile_photo
				+ ", cover_photo=" + cover_photo + ", quizz=" + quizz + ", user=" + user + "]";
	}

}
	

