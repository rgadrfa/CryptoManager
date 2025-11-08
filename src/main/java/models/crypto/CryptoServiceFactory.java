package models.crypto;

import models.crypto.controllers.AsymmetricAlgorithmController;
import models.crypto.controllers.SymmetricAlgorithmController;
import models.crypto.enums.AsymmetricTypeEncoder;
import models.crypto.enums.SymmetricTypeEncoder;
import models.crypto.interfaces.ICryptoController;
import models.key.controllers.AsymmetricKeyController;
import models.key.controllers.SymmetricKeyController;
import models.key.intefaces.IKeyPair;
import models.key.intefaces.IKeySingle;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class CryptoServiceFactory {
    public static CryptoService<IKeySingle, ICryptoController<IKeySingle>> createSymmetric(SymmetricTypeEncoder algorithm)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        return new CryptoService<>(
                new SymmetricAlgorithmController(algorithm),
                new SymmetricKeyController(algorithm)
        );
    }

    public static CryptoService<IKeyPair, ICryptoController<IKeyPair>> createAsymmetric(AsymmetricTypeEncoder algorithm)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        return new CryptoService<IKeyPair, ICryptoController<IKeyPair>>(
                new AsymmetricAlgorithmController(algorithm),
                new AsymmetricKeyController(algorithm)
        );
    }
}
