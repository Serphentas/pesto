package pesto.internal.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.SecretKey;
import org.bouncycastle.crypto.generators.SCrypt;

/**
 * General purpose cryptographic class
 * <p>
 * Methods which are used for cryptographic yet general purpose are defined
 * here, so that the *Cipher class files only contains
 * encryption/decryption-related code.
 *
 * @author Serphentas
 */
public abstract class GPCrypto {

    private static final SecureRandom rand = new SecureRandom();
    private static final int KDF_N = (int) Math.pow(2, 22),
            KDF_r = 8,
            KDF_p = 1;
    public static final int SANITIZATION_COUNT = 10000;

    /**
     * Generates a random array of bytes
     *
     * @param size width of the byte array
     *
     * @return a random array of bytes, of length size
     */
    public static byte[] randomGen(int size) {
        byte[] randBytes = new byte[size];
        rand.nextBytes(randBytes);
        return randBytes;
    }

    /**
     * Fills a byte array 10'000 times with random values to prevent future
     * retrieval of its original state
     *
     * @param array byte array to sanitize
     */
    public static void sanitize(byte[] array) {
        for (int i = 0; i < SANITIZATION_COUNT; i++) {
            rand.nextBytes(array);
        }
    }

    /**
     * Fills a char array 10'000 times with random values to prevent future
     * retrieval of its original state
     *
     * @param c char array to sanitize
     */
    public static void sanitize(char[] c) {
        for (int i = 0; i < SANITIZATION_COUNT; i++) {
            Arrays.fill(c, (char) rand.nextInt());
        }
    }

    /**
     * Overwrites a file with random bytes to prevent future retrieval of its
     * original state
     *
     * @param input     file to sanitize
     * @param passCount number of passes to make
     *
     * @throws Exception
     */
    public static void sanitize(File input, int passCount) throws Exception {
        final FileOutputStream fos = new FileOutputStream(input);

        if (input.length() > Math.pow(2, 20)) {
            final FileInputStream fis = new FileInputStream(input);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, r);
            }
            fis.close();
        } else {
            for (int i = 0; i < passCount; i++) {
                rand.nextBytes(Files.readAllBytes(input.toPath()));
            }
        }
        fos.close();
    }

    /**
     * Overwrites many byte arrays 10'000 times
     *
     * @param arrays arrays to overwrite
     */
    public static void eraseByteArrays(byte[]  
        ... arrays) {
        for (byte[] array : arrays) {
            sanitize(array);
        }
    }

    /**
     * Overwrites many SecretKey objects 10'000 times
     *
     * @param keys SecretKey objects to overwrite
     */
    public static void eraseKeys(SecretKey... keys) {
        for (SecretKey key : keys) {
            GPCrypto.sanitize(key.getEncoded());
        }
    }

    /**
     * Hashes a given string with SHA384
     * <p>
     * The input is read as a byte array, using UTF-8 as character encoding.
     *
     * @param input message
     *
     * @return message digest
     *
     * @throws Exception
     */
    public static byte[] SHA384(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA384", "BC");
        return md.digest(input.getBytes("UTF-8"));
    }

    public static byte[] SHA256(byte[] input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA256", "BC");
            return md.digest(input);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            return null;
        }
    }

    /**
     * Derives a given string (usually a password) with scrypt, using the
     * following default values:
     * <ul>
     * <li>N=2^19</li>
     * <li>p=8</li>
     * <li>r=4</li>
     * </ul>
     *
     * @param password secret value to derive the key from
     * @param salt     salt to use for this invocation
     * @param dkLen    output size, in bytes
     *
     * @return key derived from supplied password
     *
     * @throws java.io.UnsupportedEncodingException
     */
    public static byte[] scrypt(char[] password, byte[] salt, int dkLen) throws UnsupportedEncodingException {
        byte[] passBytes = charToByte(password),
                digest = SCrypt.generate(passBytes, salt, KDF_N, KDF_r, KDF_p, dkLen);
        sanitize(passBytes);
        return digest;
    }

    /**
     * Converts a char array into a byte array, using UTF-8 as the encoding
     * charset
     * <p>
     * Note: does not change the input char array by processing a clone of it
     *
     *
     * @param c char array to convert
     *
     * @return byte array representation of the char array
     */
    public static byte[] charToByte(char[] c) {
        CharBuffer charBuffer = CharBuffer.wrap(c.clone());
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                byteBuffer.position(), byteBuffer.limit());
        sanitize(charBuffer.array());
        sanitize(byteBuffer.array());
        return bytes;
    }

    /**
     * Converts a byte array into an integer
     *
     * @param b byte array to convert
     *
     * @return integer value of the byte array
     */
    public static int byteArrayToInt(byte[] b) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (b[i] & 0x000000FF) << shift;
        }
        return value;
    }

    /**
     * Converts an integer into a byte array
     *
     * @param i integer to convert
     *
     * @return byte array representation of the integer
     */
    public static byte[] intToByteArray(int i) {
        byte[] ret = new byte[4];
        ret[3] = (byte) (i & 0xFF);
        ret[2] = (byte) ((i >> 8) & 0xFF);
        ret[1] = (byte) ((i >> 16) & 0xFF);
        ret[0] = (byte) ((i >> 24) & 0xFF);
        return ret;
    }

    /**
     * * Compares two byte arrays in constant time to prevent timing attacks
     *
     * @param a array a
     * @param b array b
     *
     * @return {@code true} if the arrays are equal, else {@code false}
     */
    public static boolean isEqual(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];
        }
        return result == 0;
    }
}
