package ua.com.owu.recipehub.service.categoryRecipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.CategoryRecipeDao;
import ua.com.owu.recipehub.dto.CategoryListRecipeDto;
import ua.com.owu.recipehub.dto.CategoryRecipeDto;
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
        final List<CategoryRecipe> categoryRecipeDaoAll = categoryRecipeDao.findAll();
        final List<CategoryListRecipeDto> collect = categoryRecipeDaoAll.stream()
                .map(categoryRecipe -> {
                    CategoryListRecipeDto categoryListRecipeDto = new CategoryListRecipeDto();
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
    public CategoryListRecipeDto getCategoryRecipe(int id) {
        final CategoryRecipe categoryRecipeDaoId = categoryRecipeDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No category with id: " + id));
        CategoryListRecipeDto categoryListRecipeDto = new CategoryListRecipeDto();
        categoryListRecipeDto.setIdCategoryRecipe(categoryRecipeDaoId.getId());
        categoryListRecipeDto.setNameCategoryRecipe(categoryRecipeDaoId.getNameCategoryRecipe());
        final List<Integer> idRecipe = categoryRecipeDaoId.getRecipes()
                .stream()
                .map(Recipe::getId)
                .collect(Collectors.toList());
        categoryListRecipeDto.setRecipes(idRecipe);

        return categoryListRecipeDto;
//        return categoryRecipeDao.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public CategoryRecipeDto createCategoryRecipe(CategoryRecipeDto categoryRecipe) {
       CategoryRecipe categoryRecipeCreate = new CategoryRecipe();
        categoryRecipeCreate.setNameCategoryRecipe(categoryRecipe.getNameCategoryRecipe());
              categoryRecipeDao.saveAndFlush(categoryRecipeCreate);
        categoryRecipe.setIdCategoryRecipe(categoryRecipeCreate.getId());
        return categoryRecipe;

    }

    @Override
    public CategoryRecipeDto updateCategoryRecipe(int id, CategoryRecipeDto categoryRecipe) {
        if (!categoryRecipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No categoryRecipe found");
        }
        CategoryRecipe categoryRecipeUpdate =categoryRecipeDao.findById(id).get();
        categoryRecipeUpdate.setNameCategoryRecipe(categoryRecipe.getNameCategoryRecipe());
        categoryRecipeDao.saveAndFlush(categoryRecipeUpdate);

        categoryRecipe.setIdCategoryRecipe(id);

        return categoryRecipe;
    }

    @Override
    public void deleteCategoryRecipe(int id) {
        if (!categoryRecipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No categoryRecipe found");
        }
        categoryRecipeDao.deleteById(id);
    }
}
