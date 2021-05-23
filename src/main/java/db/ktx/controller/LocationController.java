package db.ktx.controller;

import db.ktx.entity.Location;
import db.ktx.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/location")
public class LocationController {
	@Autowired
	private LocationService service;

	@GetMapping()
	public List<Location> getLocation(){
		return service.getLocations();
	}

	@PostMapping()
	public Location createLocation (@RequestBody Location location){
		return service.insertLocation(location);
	}

	@PutMapping()
	public Location updateLocation (@RequestBody Location location) {
		return service.updateLocation(location);
	}

	@DeleteMapping("/{id}")
	public String deleteLocation (@PathVariable("id") int id){
		service.deleteById(id);
		return "Xoa thanh cong";
	}
}
