package ua.com.owu.recipehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.recipehub.models.Category;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.service.category.CategoryService;
import ua.com.owu.recipehub.service.recipe.RecipeService;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "")
    public List<Category> getCategories() {
        return categoryService.getALLCategories();
    }

    @GetMapping(value = "/{id}")
    public Category getByIdCategory(@PathVariable int id){
        return categoryService.getCategory(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Category insertCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

}
