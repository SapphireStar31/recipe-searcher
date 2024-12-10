package authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class will return the Cognito token headers.
 */
public class CognitoTokenHeader{
    @JsonProperty("kid")
    private String kid;

    @JsonProperty("alg")
    private String alg;

    /**
     * Gets the Cognito token kid.
     * @return a string with the kid
     */
    public String getKid(){
        return kid;
    }

    /**
     * Gets the Cognito algorithm.
     * @return the Cognito algorithm
     */
    public String getAlg(){
        return alg;
    }
}