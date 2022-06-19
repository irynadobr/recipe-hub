package ua.com.owu.recipehub.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.CategoryDao;
import ua.com.owu.recipehub.dao.IngredientDao;
import ua.com.owu.recipehub.models.Category;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.service.IngredientService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<Category> getALLCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategory(int id) {
        return  categoryDao.findById(id).orElseThrow(() ->new RuntimeException());

    }

    @Override
    public Category createCategory(Category category) {
        return categoryDao.saveAndFlush(category);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        category.setId(id);
        if (!categoryDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No category found");
        }
        return categoryDao.saveAndFlush(category);
    }

    @Override
    public void deleteCategory(int id) {
        if (!categoryDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No category found");
        }
        categoryDao.deleteById(id);
    }
}
