package pesto.internal.crypto;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.NoSuchPaddingException;
import pesto.internal.Folder;
import pesto.internal.Settings;

/**
 * Interface to handle database save and load operations
 *
 * @author Serphentas
 */
public interface IO {

    /**
     * Saves the given folder and all its content to the specified output file
     *
     * @param folder  folder to save
     * @param outFile destination database file
     *
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IOException
     */
    public static void save(Folder folder, File outFile) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException {
        switch (Settings.getSchemeVersion()) {
            case 0x00:
                GCMCipher.encrypt_v00(folder, outFile);
                break;
            default:
                break;
        }
    }

    /**
     * Loads a folder from a saved database file
     *
     * @param inFile database file
     *
     * @return folder contained in the database file
     */
    public static Folder load(File inFile) {
        switch (Settings.getSchemeVersion()) {
            case 0x00:

                break;
            default:
                break;
        }
    }
}
