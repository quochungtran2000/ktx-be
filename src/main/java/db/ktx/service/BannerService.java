package db.ktx.service;

import db.ktx.entity.Banner;
import db.ktx.entity.Location;
import db.ktx.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
	@Autowired
	private BannerRepository repository;

	public Banner insertBanner (Banner banner) { return repository.save(banner);}
	
	public List<Banner> getBanner(){
	return repository.findAll();
}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Banner updateBanner (Banner banner) {
		Banner baseBanner = repository.findById(banner.getId()).orElse(null);
		baseBanner.setImage_url(banner.getImage_url());
		baseBanner.setLink(banner.getLink());
		baseBanner.setDescription(banner.getDescription());
		return repository.save(baseBanner);

	}
}
