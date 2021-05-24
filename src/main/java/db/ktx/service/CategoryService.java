package db.ktx.service;

import db.ktx.entity.Category;
import db.ktx.entity.Location;
import db.ktx.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category insertCategory (Category category) { return repository.save(category) ;}
	
	public List<Category> insertCategories(List<Category> categories){
		return repository.saveAll(categories);
	}
	
	public List<Category> getCategory(){
	return repository.findAll();
}


	public Category updateCategory(Category category) {
		Category baseCategory = repository.findById(category.getCategory_id()).orElse(null);
		baseCategory.setName(category.getName());
		baseCategory.setClasses(category.getClasses());
		return repository.save(baseCategory);
	}


	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
