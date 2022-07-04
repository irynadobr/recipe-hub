package ua.com.owu.recipehub.service.categoryRecipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.CategoryRecipeDao;
import ua.com.owu.recipehub.dto.CategoryListRecipeDto;
import ua.com.owu.recipehub.models.CategoryRecipe;
import ua.com.owu.recipehub.models.Recipe;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryRecipeServiceImpl implements CategoryRecipeService {
    @Autowired
    private CategoryRecipeDao categoryRecipeDao;


    @Override
    public List<CategoryListRecipeDto> getALLCategoriesRecipes() {
        final List<CategoryRecipe>categoryRecipeDaoAll =categoryRecipeDao.findAll();
        final List<CategoryListRecipeDto> collect = categoryRecipeDaoAll.stream()
                .map(categoryRecipe -> {
                    CategoryListRecipeDto categoryListRecipeDto  = new CategoryListRecipeDto();
                    categoryListRecipeDto.setIdCategoryRecipe(categoryRecipe.getId());
                    categoryListRecipeDto.setNameCategoryRecipe(categoryRecipe.getNameCategoryRecipe());
                    final List<Integer> idRecipe = categoryRecipe.getRecipes().stream()
                            .map(Recipe::getId)
                            .collect(Collectors.toList());
                    categoryListRecipeDto.setRecipes(idRecipe);
                   return categoryListRecipeDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public CategoryRecipe getCategoryRecipe(int id) {
        return  categoryRecipeDao.findById(id).orElseThrow(() ->new RuntimeException());

    }

    @Override
    public CategoryRecipe createCategoryRecipe(CategoryRecipe categoryRecipe) {
        return categoryRecipeDao.saveAndFlush(categoryRecipe);
    }

    @Override
    public CategoryRecipe updateCategoryRecipe(int id, CategoryRecipe categoryRecipe) {
        categoryRecipe.setId(id);
        if (!categoryRecipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No categoryRecipe found");
        }
        return categoryRecipeDao.saveAndFlush(categoryRecipe);
    }

    @Override
    public void deleteCategoryRecipe(int id) {
        if (!categoryRecipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No categoryRecipe found");
        }
        categoryRecipeDao.deleteById(id);
    }
}
