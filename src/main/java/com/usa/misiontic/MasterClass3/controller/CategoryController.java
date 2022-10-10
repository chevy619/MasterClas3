
package com.usa.misiontic.MasterClass3.controller;

import com.usa.misiontic.MasterClass3.entities.Category;
import com.usa.misiontic.MasterClass3.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    
    @PutMapping("/id")
    public Category getCategory(@PathVariable("id") int categoryId){
        return categoryService.getCategory(categoryId).get();
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }
    
    @PutMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId){
        return categoryService.delete(categoryId);
    }
    
}
