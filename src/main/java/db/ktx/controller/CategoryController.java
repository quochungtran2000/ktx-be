package db.ktx.controller;

import db.ktx.entity.Category;
import db.ktx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class CategoryController {
	
	@Autowired
	private CategoryService service;

	@GetMapping("category")
	public List<Category> getCategory(){
		return service.getCategory();
	}
	
	@PostMapping("/createCategory")
	public Category createUser (@RequestBody Category category){
		return service.insertCategory(category);
	}
	
}
