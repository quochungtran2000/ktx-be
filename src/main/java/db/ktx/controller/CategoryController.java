package db.ktx.controller;

import db.ktx.entity.Category;
import db.ktx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category){
        return categoryService.inserCategory(category);
    }

    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/category/{id}")
    public Optional<Category> getCategoryById (@PathVariable int id){

        return categoryService.getCategoryById(id);
    }
    @GetMapping("/category/{name}")
    public Category getCategoryByName (@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
    @PutMapping("/update")
    public Category updateCategory (@RequestBody Category category){
        return categoryService.updateCategory(category);
    }


}
