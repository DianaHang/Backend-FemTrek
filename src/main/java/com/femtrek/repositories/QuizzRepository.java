package com.femtrek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.femtrek.models.Quizz;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz,Long>{

}
