package db.ktx.service;

import db.ktx.entity.Banner;
import db.ktx.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
	@Autowired
	private BannerRepository repository;

	public Banner insertBanner (Banner banner) { return repository.save(banner) ;}
	
	public List<Banner> getBanner(){
	return repository.findAll();
}
}
