package db.ktx.controller;

import db.ktx.entity.Banner;
import db.ktx.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BannerController {
	@Autowired
	private BannerService service;
	
	@GetMapping("banner")
	public List<Banner> getBanner(){
		return service.getBanner();
	}
	
	@PostMapping("/createBanner")
	public Banner createBanner (@RequestBody Banner banner){
	return service.insertBanner(banner);
}

}
