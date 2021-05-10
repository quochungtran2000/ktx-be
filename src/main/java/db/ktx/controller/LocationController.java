package db.ktx.controller;

import db.ktx.entity.Location;
import db.ktx.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LocationController {
	@Autowired
	private LocationService service;

	@GetMapping("location")
	public List<Location> getUsers(){
		return service.getLocations();
	}

	@PostMapping("/createLocation")
	public Location createUser (@RequestBody Location location){
		return service.insertLocation(location);
	}
	
}
