package pesto.internal.properties;

/**
 * Represents a username, used as a {@link Property}
 *
 * @author Serphentas
 */
public class Username extends Property {

    private final String username;

    /**
     * Creates a {@link Property} of type {@code username} with the specified
     * username
     *
     * @param username username
     */
    public Username(String username) {
        super("username");
        this.username = username;
    }

    /**
     * Returns the username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }
}
