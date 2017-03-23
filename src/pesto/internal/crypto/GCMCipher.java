package pesto.internal.crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.generators.SCrypt;
import pesto.internal.Folder;

/**
 * Implements encryption features for database saving
 * <p>
 * Uses AES-256 with GCM and scrypt as KDF
 *
 * @author Serphentas
 */
abstract class GCMCipher {

    private static final String CIPHER = "AES/GCM/NoPadding",
            CRYPTO_PROVIDER = "BC";
    private static final int CIPHER_KEY_BITS = 256,
            GCM_NONCE_BYTES = 12,
            GCM_TAG_BITS = 128,
            S_BYTES = 64,
            KDF_r = 8,
            KDF_p = 1;

    /**
     * Encryptes the given folder and saves it into the specified output file
     *
     * @param folder  folder to save
     * @param outFile output file
     *
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IOException
     */
    public static void encrypt_v00(Folder folder, File outFile) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException {
        // generating nonce, KDF salt and secret key
        byte[] S = GPCrypto.randomGen(S_BYTES),
                N = GPCrypto.randomGen(12);
        SecretKey K = new SecretKeySpec(SCrypt.generate(GPCrypto.randomGen(64),
                S, (int) Math.pow(2, 15), KDF_r, KDF_p, CIPHER_KEY_BITS / 8), 0,
                CIPHER_KEY_BITS / 8, "AES");

        // setting up cipher and streams
        Cipher cipher = Cipher.getInstance(CIPHER, CRYPTO_PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, K, new GCMParameterSpec(
                GCM_TAG_BITS, N, 0, GCM_NONCE_BYTES));
        ObjectOutputStream oos = new ObjectOutputStream(new CipherOutputStream(new FileOutputStream(outFile), cipher));

        // writing encrypted database and closing streams
        oos.writeObject(folder);
        oos.close();

        // clearing sensitive data
        GPCrypto.eraseByteArrays(S, N);
        GPCrypto.eraseKeys(K);
    }
}
