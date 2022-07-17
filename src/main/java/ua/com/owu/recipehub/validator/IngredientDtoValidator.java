package ua.com.owu.recipehub.validator;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.owu.recipehub.dto.IngredientDto;
import ua.com.owu.recipehub.models.Ingredient;
@Component
public class IngredientDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return IngredientDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
IngredientDto ingredientDto = (IngredientDto) target;
if (StringUtils.isNotBlank(ingredientDto.getNameIngredient()) && !CharUtils.isAsciiAlphaUpper(ingredientDto.getNameIngredient().charAt(0))){
    errors.rejectValue("nameIngredient", "ingredient.nameIngredient.capital-letter", "ingredient nameIngredient should start with capital letter");
}
    }
}


