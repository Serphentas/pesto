package pesto.internal.properties;

/**
 * Represents a password, used as a {@link Property}
 *
 * @author Serphentas
 */
public class Password extends Property {

    private final char[] pass;

    /**
     * Creates a {@link Property} of type {@code password} with the specified
     * password
     *
     * @param pass password
     */
    public Password(char[] pass) {
        super("password");
        this.pass = pass;
    }

    /**
     * Returns the password
     *
     * @return password
     */
    public char[] getPassword() {
        return pass;
    }
}
