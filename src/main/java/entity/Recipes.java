package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * This class will hold information about a recipe and be able to access
 * data in that recipe.
 *
 * @author Karissa
 */
public class Recipes {
    private int recipeID;
    private String recipeName;


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
