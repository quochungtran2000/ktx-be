package db.ktx.service;

import db.ktx.entity.Location;
import db.ktx.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    //add new locaion
    public Location insertLocation(Location location){
        return locationRepository.save(location);
    }

    //Get all location
    public List<Location> getAllLocation(){
        return locationRepository.findAll();
    }
    //Get LocationByName
    public Optional<Location> getByLocationName(String name){
        return locationRepository.findByLocationName(name);
    }

    //Update Location
    public Location updateLocation(Location location){
        Location location1 = locationRepository.findByLocationName(location.getName()).orElse(null);
        location1.setLocation_address(location.getLocation_address());
        return locationRepository.save(location1);
    }

}
