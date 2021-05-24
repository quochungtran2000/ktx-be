package db.ktx.controller;

import db.ktx.entity.Category;
import db.ktx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
//@CrossOrigin(origins = "*")
=======
@CrossOrigin(origins = "*")
>>>>>>> 0e680678640b97293e4f16c35aab848a9872729f
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;

	@GetMapping()
	public List<Category> getCategory(){
		return service.getCategory();
	}
	
	@PostMapping()
	public Category createCategory (@RequestBody Category category){
		return service.insertCategory(category);
	}

	@PutMapping()
	public Category updateCategory (@RequestBody Category category) {
		return service.updateCategory(category);
	}
	@DeleteMapping("/{id}")
	public String deleteLocation (@PathVariable("id") int id){
		service.deleteById(id);
		return "Xoa thanh cong";
	}
}
