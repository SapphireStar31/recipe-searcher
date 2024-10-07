package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.*;

/**
 * This class will hold information about ingredients and its data.
 *
 * @author Karissa
 */
@Entity(name = "Ingredients")
@Table(name = "Ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int ingredientID;

    @Column(name = "IngredientName")
    private String ingredientName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Recipes> recipes = new ArrayList<>();


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


    /**
     * Gets all Recipes associated with the Ingredient.
     * @return recipes with the ingredient
     */
    public List<Recipes> getRecipes() {
        return recipes;
    }

    /**
     * Sets all the recipes associated with the Ingredient.
     * @param recipes the recipes with this ingredient
     */
    public void setRecipes(List<Recipes> recipes) {
        this.recipes = recipes;
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
