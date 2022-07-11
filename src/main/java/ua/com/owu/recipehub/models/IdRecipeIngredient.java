package ua.com.owu.recipehub.models;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class IdRecipeIngredient implements Serializable {

    private int recipe_id;
    private int ingredient_id;



}
