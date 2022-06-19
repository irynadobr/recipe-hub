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
if (StringUtils.isNotBlank(ingredient.getType_ukr()) && !CharUtils.isAsciiAlphaUpper(ingredient.getType_ukr().charAt(0))){
    errors.rejectValue("type_ukr", "ingredient.type_ukr.capital-letter", "ingredient type_ukr should start with capital letter");
}
    }
}
