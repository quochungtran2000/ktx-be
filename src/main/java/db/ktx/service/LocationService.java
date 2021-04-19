package db.ktx.service;

import db.ktx.entity.Location;
import db.ktx.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
	@Autowired
	private LocationRepository repository;

	public Location insertLocation (Location location) { return repository.save(location) ;}

	public List<Location> insertLocations(List<Location> locations){
	return repository.saveAll(locations);
}

	public List<Location> getLocations(){
	return repository.findAll();
}

}
