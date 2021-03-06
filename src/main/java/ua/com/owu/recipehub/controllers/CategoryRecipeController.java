package ua.com.owu.recipehub.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.recipehub.dto.CategoryListRecipeDto;
import ua.com.owu.recipehub.dto.CategoryRecipeDto;
import ua.com.owu.recipehub.models.CategoryRecipe;
import ua.com.owu.recipehub.service.categoryRecipe.CategoryRecipeService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryRecipeController {
    @Autowired
    private CategoryRecipeService categoryRecipeService;

//    @GetMapping(value = "")
//    public List<Category> getCategories() {
//        return categoryService.getALLCategories();
//    }

    //        @GetMapping(value = "")
//    public List<CategoryListRecipeDto> getCategories() {
//        return categoryService.getALLCategories();
//    }
//
//    @GetMapping(value = "/{id}")
//    public Category getByIdCategory(@PathVariable int id){
//        return categoryService.getCategory(id);
//    }
//
//    @PostMapping(value = "")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Category insertCategory(@RequestBody Category category) {
//        return categoryService.createCategory(category);
//    }
//
//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
//        return categoryService.updateCategory(id, category);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCategory(@PathVariable int id) {
//        categoryService.deleteCategory(id);
//    }
    @GetMapping(value = "")
    public List<CategoryListRecipeDto> getCategoriesRecipes() {
        return categoryRecipeService.getALLCategoriesRecipes();

    }

    @GetMapping(value = "/{id}")
    public CategoryListRecipeDto getByIdCategoryRecipe(@PathVariable int id) {
        return categoryRecipeService.getCategoryRecipe(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryRecipeDto insertCategoryRecipe(@RequestBody CategoryRecipeDto categoryRecipe) {
        return categoryRecipeService.createCategoryRecipe(categoryRecipe);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CategoryRecipeDto updateCategoryRecipe(@PathVariable int id, @RequestBody CategoryRecipeDto categoryRecipe) {
        return categoryRecipeService.updateCategoryRecipe(id, categoryRecipe);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryRecipe(@PathVariable int id) {
        categoryRecipeService.deleteCategoryRecipe(id);
    }

}
