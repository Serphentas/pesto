package pesto.internal;

/**
 * Represents an entry in the password database
 * <p>
 * Data fields include:
 * <ul>
 * <li>name</li>
 * <li>username</li>
 * <li>password</li>
 * <li>login URL</li>
 * <li>comments</li>
 * </ul>
 *
 * @author Serphentas
 */
public class Entry {

    private final long creationTime;
    private final String name;

    private String username,
            loginURL;
    private char[] password;

    /**
     * Creates an {@link Entry} object with the specified name
     *
     * @param name
     */
    public Entry(String name) {
        this.name = name;
        this.creationTime = System.currentTimeMillis();
    }

    /**
     * Returns the entry's name
     *
     * @return entry name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the entry's creation time
     * @return entry creation time
     */
    public long getCreationTime() {
        return creationTime;
    }

    /**
     * Returns the entry's username field
     *
     * @return username field
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the entry's password field
     *
     * @return password field
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * Returns the entry's login URL field
     *
     * @return login URL field
     */
    public String getLoginURL() {
        return this.loginURL;
    }

}
