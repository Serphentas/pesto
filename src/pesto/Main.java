package pesto;

import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pesto.visual.DefaultFrame;

/**
 * Starting point of the application
 *
 * @author Serphentas
 */
public class Main {

    public static void main(String args[]) {
        Security.addProvider(new BouncyCastleProvider());
        DefaultFrame.main(args);
    }
}
