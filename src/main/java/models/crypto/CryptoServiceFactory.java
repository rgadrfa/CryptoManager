package models.crypto;

import models.crypto.controllers.AsymmetricAlgorithmController;
import models.crypto.controllers.SymmetricAlgorithmController;
import models.crypto.enums.AsymmetricEncoder;
import models.crypto.enums.SymmetricEncoder;
import models.crypto.interfaces.IAlgorithmController;
import models.key.intefaces.IKeyPair;
import models.key.intefaces.IKeySingle;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class CryptoServiceFactory {
    public static CryptoAlgorithmService<IKeySingle, IAlgorithmController<IKeySingle>> create(
            SymmetricEncoder algorithm)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        return new CryptoAlgorithmService<>(
                new SymmetricAlgorithmController(algorithm)
        );
    }

    public static CryptoAlgorithmService<IKeyPair, IAlgorithmController<IKeyPair>> create(
            AsymmetricEncoder algorithm)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        return new CryptoAlgorithmService<>(
                new AsymmetricAlgorithmController(algorithm)
        );
    }
}
