package pesto.internal;

/**
 * Implementation of program-wide variables
 *
 * @author Serphentas
 */
public abstract class Settings {

    private static byte SCHEME_VERSION = 0x00;

    /**
     * Sets the new encryption scheme version to use
     *
     * @param b new encryption scheme version
     */
    public static void setSchemeVersion(byte b) {
        SCHEME_VERSION = b;
    }

    /**
     * Returns the encryption scheme version currently enforced
     *
     * @return current encryption scheme version
     */
    public static byte getSchemeVersion() {
        return SCHEME_VERSION;
    }
}
