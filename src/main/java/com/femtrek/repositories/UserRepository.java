package com.femtrek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.femtrek.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
