package pesto.internal.properties;

import java.io.Serializable;

/**
 * Represents properties an {@link Entry} may have, such as passwords and
 * usernames
 *
 * @author Serphentas
 */
public abstract class Property implements Serializable {

    private final String type;

    /**
     * Creates a property of the specified type
     *
     * @param type
     */
    public Property(String type) {
        this.type = type;
    }

    /**
     * Returns the property's type
     *
     * @return property type
     */
    public String getType() {
        return type;
    }
}
