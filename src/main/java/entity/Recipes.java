package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.*;

/**
 * This class will hold information about a recipe and be able to access
 * data in that recipe.
 *
 * @author Karissa
 */
@Entity
@Table(name = "RecipeNames")
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int recipeID;

    @Column(name = "RecipeName")
    private String recipeName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ingredients> ingredients = new ArrayList<>();


    /**
     * Instantiates a new Recipe name.
     */
    public Recipes() {

    }

    /**
     * Instantiates a new Recipe with the recipe name.
     *
     * @param recipeName the recipes name
     */
    public Recipes(String recipeName) {
        this.recipeName = recipeName;
    }


    /**
     * Get the recipe ID number.
     * @return the recipe ID number
     */
    public int getRecipeID() {
        return recipeID;
    }

    /**
     * Sets the recipe ID number.
     * @param recipeID the recipe ID number
     */
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }


    /**
     * Gets the recipes name.
     * @return the recipes name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets the recipes name.
     * @param recipeName the recipes name
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }


    /**
     * Gets the ingredients associated with the recipe.
     * @return the ingredients in the recipe
     */
    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    /**
     * Sets the ingredients associated with the recipe.
     * @param ingredients the ingredients in the recipe
     */
    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return recipeID == recipes.recipeID && Objects.equals(recipeName, recipes.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeID, recipeName);
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "recipeID=" + recipeID +
                ", recipeName='" + recipeName + '\'' +
                '}';
    }
}
