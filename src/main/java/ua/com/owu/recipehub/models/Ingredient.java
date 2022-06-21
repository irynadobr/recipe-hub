
package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  @NotBlank
     private String typeUkr;
     private String nameUkr;
     private String type;
     private String name;
     @ManyToMany(targetEntity = Recipe.class)
     @JsonIgnore
     private List<Recipe> recipes;
     private int weight;
     private int calories;
     private double totalProtein;
     private double totalFat;
     private double saturatedFattyAcids;
     private double monounsaturatedFattyAcids;
     private double polyunsaturatedFattyAcids;
     private double carbohydrate;
     private double fiber;
     private double sugars;
     private int vitaminA;
     private int thiaminVitaminB1;
     private int riboflavinVitaminB2;
     private int niacinVitaminB3;
     private int cholineVitaminB4;
     private int pantothenicAcidVitaminB5;
     private int vitaminB6;
     private int folicAcidVitaminB5;
     private double vitaminB12Cobalamin;
     private int vitaminD;
     private int vitaminEAlphaTocopherol;
     private double vitaminK;
     private int vitaminCAscorbicAcid;
     private int cholesterol;
     private int sodium;
     private int potassium;
     private int calcium;
     private double copper;
     private int phosphorusP;
     private int magnesium;
     private double iron;
     private double zinc;
     private double manganese;
     private double selenium;

}
