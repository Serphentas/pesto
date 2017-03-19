package pesto.internal;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.bouncycastle.util.encoders.Hex;
import pesto.internal.crypto.GPCrypto;
import pesto.internal.properties.Password;
import pesto.internal.properties.Property;
import pesto.internal.properties.Username;

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
public class Entry implements Serializable {

    private final Map<String, Property> properties = new HashMap<>();
    private final long creationTime;
    private final String name,
            uuid;

    private Iterator<Map.Entry<String, Property>> propertiesIter;
    private String loginURL;

    /**
     * Creates an {@link Entry} with the specified name and {@link Property}
     * elements
     *
     * @param name  name of the entry
     * @param props array of properties
     */
    public Entry(String name, Property... props) {
        this.name = name;
        this.creationTime = System.currentTimeMillis();
        this.uuid = Hex.toHexString(GPCrypto.SHA256(GPCrypto.randomGen(32)));
        for (Property p : props) {
            properties.put(p.getType(), p);
        }
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
     *
     * @return entry creation time
     */
    public long getCreationTime() {
        return creationTime;
    }

    /**
     * Returns the entry's UUID
     *
     * @return entry UUID
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Returns the entry's property with the given type
     *
     * @param type type of property to get
     *
     * @return matching property if found, else {@code null}
     */
    public Property getProperty(String type) {
        Property tmpProperty;
        propertiesIter = properties.entrySet().iterator();
        while (propertiesIter.hasNext()) {
            tmpProperty = propertiesIter.next().getValue();
            if (tmpProperty.getType().equals(type)) {
                return tmpProperty;
            }
        }
        return null;
    }

    /**
     * Sets the given property for the entry
     * <p>
     * If a property of the same type exists, its content will be updated with
     * the new one
     *
     * @param p property to set
     */
    public void setProperty(Property p) {
        properties.put(p.getType(), p);
    }

    /**
     * Returns the entry's username field
     *
     * @return username field
     */
    public String getUsername() {
        return ((Username) getProperty("username")).getUsername();
    }

    /**
     * Returns the entry's password field
     *
     * @return password field
     */
    public char[] getPassword() {
        return ((Password) getProperty("password")).getPassword();
    }

    /**
     * Returns the entry's login URL field
     *
     * @return login URL field
     */
    public String getLoginURL() {
        return this.loginURL;
    }

    /**
     * Sets the entry's username field
     *
     * @param username new username
     */
    public void setUsername(String username) {
        setProperty(new Username(username));
    }

    /**
     * Sets the entry's password field
     *
     * @param password new password
     */
    public void setPassword(char[] password) {
        setProperty(new Password(password));
    }
}
