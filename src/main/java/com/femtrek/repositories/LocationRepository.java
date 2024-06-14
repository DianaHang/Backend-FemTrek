package com.femtrek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.femtrek.models.Location;

@Repository
public interface LocationRepository extends JpaRepository <Location, Long>{

}
