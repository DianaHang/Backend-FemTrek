package com.femtrek.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.femtrek.models.Location;
import com.femtrek.services.LocationService;


@RestController
@RequestMapping("/api/location")
public class LocationController {
	@Autowired
	private LocationService locationService;

	//GET
	
	@GetMapping
	public List<Location> getAllLocations(){
		return locationService.findAllLocations();
	}
	

			@GetMapping("{id}")
			public ResponseEntity<Location> getlocationById(@PathVariable Long id){
				return locationService.findlocationById(id)
						.map(ResponseEntity::ok)
						.orElse(ResponseEntity.notFound().build());
			}
			
	// POST
				@PostMapping
				public Location createlocation (@RequestBody Location location) {
					return locationService.savelocation(location);
				}

			
			
				// DELETE
			@DeleteMapping("{id}")
			public ResponseEntity<Void> deletelocation(@PathVariable Long id){
				return locationService.findlocationById(id)
						.map(location -> { locationService.deletelocationById(id); return ResponseEntity.ok().<Void>build();})
						.orElse(ResponseEntity.notFound().build());
			}
}
