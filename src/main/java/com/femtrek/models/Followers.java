package com.femtrek.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="followers")
public class Followers {
		
		//Columnas de la tabla
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="user_information_user_id")
			private int user_information_user_id;
		
			@Column(name="user_information_user_id1")
			private int user_information_user_id1;

			
			//Constructor vacío
			public Followers() {
				super();
			}

			//Constructor con campos
			public Followers(int user_information_user_id, int user_information_user_id1) {
				super();
				this.user_information_user_id = user_information_user_id;
				this.user_information_user_id1 = user_information_user_id1;
			}


			//G&S
			public int getUser_information_user_id() {
				return user_information_user_id;
			}


			public void setUser_information_user_id(int user_information_user_id) {
				this.user_information_user_id = user_information_user_id;
			}


			public int getUser_information_user_id1() {
				return user_information_user_id1;
			}


			public void setUser_information_user_id1(int user_information_user_id1) {
				this.user_information_user_id1 = user_information_user_id1;
			}

			//To String
			@Override
			public String toString() {
				return "Followers [user_information_user_id=" + user_information_user_id
						+ ", user_information_user_id1=" + user_information_user_id1 + "]";
			}

			
			
			
			
	
}
