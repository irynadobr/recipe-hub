package ua.com.owu.recipehub.validator;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.owu.recipehub.models.Ingredient;
@Component
public class IngredientValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Ingredient.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
Ingredient ingredient = (Ingredient) target;
if (StringUtils.isNotBlank(ingredient.getTypeUkr()) && !CharUtils.isAsciiAlphaUpper(ingredient.getTypeUkr().charAt(0))){
    errors.rejectValue("typeUkr", "ingredient.typeUkr.capital-letter", "ingredient typeUkr should start with capital letter");
}
    }
}
