package db.ktx.controller;

import db.ktx.entity.Location;
import db.ktx.entity.User;
import db.ktx.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class LocationController {
    @Autowired
    LocationService locationService;

    @PostMapping("/createLocation")
    public Location createLocation(@RequestBody Location location){
        return locationService.insertLocation(location);
    }
    @GetMapping("/location")
    public List<Location> getAllLocation(){
        return locationService.getAllLocation();
    }
    @GetMapping("/location/{name}")
    public Optional<Location> getLocationByName(@PathVariable String name){
        return locationService.getByLocationName(name);
    }

    @PutMapping("/updateLocation")
    public Location updateLocation (@RequestBody Location location){
        return locationService.updateLocation(location);
    }




}
