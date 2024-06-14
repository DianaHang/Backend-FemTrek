package com.femtrek.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.femtrek.models.Location;
import com.femtrek.repositories.LocationRepository;


@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;
	
	//Get sólo un location
	
	public List<Location> findAllLocations(){
		return locationRepository.findAll();
	}
	
		public Optional<Location> findlocationById(Long id){
			return locationRepository.findById(id);
		}
		
		//Get sólo un location
				public Optional<Location> findLocationById(Long id){
					return locationRepository.findById(id);
				}
		
		//POST
		public Location savelocation (Location location) {
			return locationRepository.save(location);
		}

		
		//DELETE
		public void deletelocationById(Long id) {
			locationRepository.deleteById(id);
		}

}
