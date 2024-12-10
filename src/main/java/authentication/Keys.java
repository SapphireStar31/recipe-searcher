package authentication;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class will return a list of the Cognito keys.
 */
public class Keys{
    @JsonProperty("keys")
    private List<KeysItem> keys;

    /**
     * Gets the Cognito keys.
     * @return a list of Cognito keys
     */
    public List<KeysItem> getKeys(){
        return keys;
    }
}