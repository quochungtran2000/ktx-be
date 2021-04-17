package db.ktx.service;

import db.ktx.entity.Category;
import db.ktx.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    //insert category
    public Category inserCategory(Category category) {
        return categoryRepository.save(category);
    }
    //get all category
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    //Get CategoryById
    public Optional<Category> getCategoryById(int id){
        return categoryRepository.findById(id);
    }
    //Get CategoryByName
    public Category getCategoryByName(String name)
    {
        return categoryRepository.findByCategoryName(name);
    }
    //Update category
    public Category updateCategory(Category category){
        Category baseCategory = categoryRepository.findById(category.getCategoryid()).orElse(null);
        baseCategory.setCatename(category.getCatename());
        baseCategory.setPriority(category.getPriority());
        baseCategory.setDescriptions(category.getDescriptions());
        return categoryRepository.save(baseCategory);
    }



}
