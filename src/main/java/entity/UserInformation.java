package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.*;

/**
 * This class will hold information about users and their data.
 *
 * @author Karissa
 */
@Entity(name = "UserInformation")
@Table(name = "UserInformation")
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int userID;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "UserEmail")
    private String userEmail;

    @Column(name = "Username")
    private String username;

    @OneToMany(
            mappedBy = "userInformation",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    private List<Recipes> recipes = new ArrayList<>();



    /**
     * Instantiates a new users' information.
     */
    public UserInformation() {
    }

    /**
     * Instantiates a new users' information.
     * @param fullName the users full name
     * @param userEmail the users email
     * @param username the users username
     */
    public UserInformation(String fullName, String userEmail, String username) {
        this.fullName = fullName;
        this.userEmail = userEmail;
        this.username = username;
    }


    /**
     * Gets users ID number.
     * @return the user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the users ID number.
     * @param userID the user ID number
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }


    /**
     * Gets users full name.
     * @return the users full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the users full name.
     * @param fullName the users full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    /**
     * Gets users email address.
     * @return the users email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the users email address.
     * @param userEmail the users email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    /**
     * Gets the users username.
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the users username.
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets recipes associated with this user.
     * @return a list of recipes
     */
    public List<Recipes> getRecipes() {
        return recipes;
    }

    /**
     * Sets recipes associated with this user.
     * @param recipes a list of recipes
     */
    public void setRecipes(List<Recipes> recipes) {
        this.recipes = recipes;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInformation that = (UserInformation) o;
        return userID == that.userID && Objects.equals(fullName, that.fullName) && Objects.equals(userEmail, that.userEmail) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, fullName, userEmail, username);
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "userID=" + userID +
                ", fullName='" + fullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
