package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * This class will hold information about ingredients and its data.
 *
 * @author Karissa
 */
public class Ingredients {
    private int ingredientID;
    private String ingredientName;


    /**
     * Instantiates a new Ingredient.
     */
    public Ingredients() {

    }

    /**
     * Instantiates a new Ingredient with the Ingredients name.
     * @param ingredientName the name of the ingredient
     */
    public Ingredients(String ingredientName) {
        this.ingredientName = ingredientName;
    }


    /**
     * Gets the ingredients ID number.
     * @return the ingredients ID number
     */
    public int getIngredientID() {
        return ingredientID;
    }

    /**
     * Sets the ingredients ID number.
     * @param ingredientID the ingredients ID number
     */
    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }


    /**
     * Get the ingredients name.
     * @return the name of the ingredient
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Sets the ingredients name.
     * @param ingredientName the name of the ingredient
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return ingredientID == that.ingredientID && Objects.equals(ingredientName, that.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientID, ingredientName);
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientID=" + ingredientID +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
