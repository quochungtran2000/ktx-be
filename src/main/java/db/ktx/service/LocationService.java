package db.ktx.service;

import db.ktx.entity.Location;
import db.ktx.entity.Post;
import db.ktx.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Location updateLocation (Location location) {
		Location baseLocation = repository.findById(location.getLocation_id()).orElse(null);
		baseLocation.setAddress(location.getAddress());
		baseLocation.setName(location.getName());
		return repository.save(baseLocation);
	}
}
