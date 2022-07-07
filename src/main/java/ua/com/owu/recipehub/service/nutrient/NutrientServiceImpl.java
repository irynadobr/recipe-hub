package ua.com.owu.recipehub.service.nutrient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.NutrientDao;
import ua.com.owu.recipehub.dto.NutrientsListIngredientDTO;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.models.Nutrient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NutrientServiceImpl implements NutrientService {

    @Autowired
    private NutrientDao nutrientDao;


    @Override
    public List<NutrientsListIngredientDTO> getAllNutrients() {
        final List<Nutrient> nutrientDaoAll = nutrientDao.findAll();
        final List<NutrientsListIngredientDTO> collect = nutrientDaoAll.stream()
                .map(nutrient -> {
                    NutrientsListIngredientDTO nutrientsListIngredientDTO = new NutrientsListIngredientDTO();
                    nutrientsListIngredientDTO.setIdNutrient(nutrient.getId());
                    nutrientsListIngredientDTO.setNameNutrient(nutrient.getNameNutrient());
                    final List<Integer> idIngredient = nutrient.getIngredients().stream()
                            .map(Ingredient::getId)
                            .collect(Collectors.toList());
                    nutrientsListIngredientDTO.setIngredients(idIngredient);
                    return nutrientsListIngredientDTO;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Nutrient getNutrient(int id) {
        return nutrientDao.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Nutrient createNutrient(Nutrient nutrient) {
        return nutrientDao.saveAndFlush(nutrient);
    }

    @Override
    public Nutrient updateNutrient(int id, Nutrient nutrient) {
        nutrient.setId(id);
        if (!nutrientDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No nutrient found");
        }
        return nutrientDao.saveAndFlush(nutrient);
    }

    @Override
    public void deleteNutrient(int id) {
        if (!nutrientDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No nutrient found");
        }
        nutrientDao.deleteById(id);
    }
}
