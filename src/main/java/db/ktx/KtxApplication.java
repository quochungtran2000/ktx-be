package db.ktx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class KtxApplication {

	public static void main(String[] args) {
		SpringApplication.run(KtxApplication.class, args);
	}

}

@RestController
class MyController {
	
	@Autowired
	IHocsinh repo;
	@GetMapping("/")
	public List<Hocsinh> home(){
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Hocsinh> getbyId(
		@PathVariable("id") String id
		){
		return repo.findById(id);
	}
}
