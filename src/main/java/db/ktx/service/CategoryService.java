package db.ktx.service;

import db.ktx.entity.Category;
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

}
