package com.femtrek.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.femtrek.models.Followers;

@Repository
public interface FollowersRepository extends JpaRepository <Followers, Long>{

}
