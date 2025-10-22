package crypto;

import crypto.algorithm.controllers.AsymmetricAlgorithmController;
import crypto.algorithm.controllers.SymmetricAlgorithmController;
import crypto.algorithm.enums.AsymmetricTypeEncoder;
import crypto.algorithm.enums.SymmetricTypeEncoder;
import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.keys.controllers.AsymmetricKeyController;
import crypto.keys.controllers.SymmetricKeyController;
import crypto.keys.intefaces.IKeyPair;
import crypto.keys.intefaces.IKeySingle;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class CryptoServiceFactory {
    public static CryptoService<IKeySingle, ICryptoAlgorithm<IKeySingle>> createSymmetric(SymmetricTypeEncoder algorithm)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        return new CryptoService<>(
                new SymmetricAlgorithmController(algorithm),
                new SymmetricKeyController(algorithm)
        );
    }

    public static CryptoService<IKeyPair, ICryptoAlgorithm<IKeyPair>> createAsymmetric(AsymmetricTypeEncoder algorithm)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        return new CryptoService<IKeyPair, ICryptoAlgorithm<IKeyPair>>(
                new AsymmetricAlgorithmController(algorithm),
                new AsymmetricKeyController(algorithm)
        );
    }
}
