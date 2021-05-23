package db.ktx.controller;

import db.ktx.entity.Banner;
import db.ktx.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/banner")
public class BannerController {
	@Autowired
	private BannerService service;
	
	@GetMapping()
	public List<Banner> getBanner(){
		return service.getBanner();
	}
	
	@PostMapping()
	public Banner createBanner (@RequestBody Banner banner){
	return service.insertBanner(banner);
}

	@PutMapping()
	public Banner updateBanner (@RequestBody Banner banner) {
		return service.updateBanner(banner);
	}

	@DeleteMapping("/{id}")
	public String deleteBanner (@PathVariable("id") int id){
		service.deleteById(id);
		return "Xoa thanh cong";
	}

}
