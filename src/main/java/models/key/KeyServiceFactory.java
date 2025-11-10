package models.key;

import models.crypto.enums.SymmetricKeyType;
import models.key.controllers.AsymmetricKeyController;
import models.key.controllers.SymmetricKeyController;
import models.key.controllers.util.KeyDestroyerController;
import models.key.controllers.util.KeyStoreController;
import models.key.enums.AsymmetricKeyType;
import models.key.intefaces.IKeyPair;
import models.key.intefaces.IKeySingle;

import java.security.NoSuchAlgorithmException;

public class KeyServiceFactory {
    public static KeyService<IKeySingle> createSymmetricKeyService(SymmetricKeyType keyType)
            throws NoSuchAlgorithmException {
        return new KeyService<>(
                new SymmetricKeyController(keyType),
                new KeyStoreController<>(),
                new KeyDestroyerController<>()
        );
    }

    public static KeyService<IKeyPair> createAsymmetricKeyService(AsymmetricKeyType keyType)
            throws NoSuchAlgorithmException {
        return new KeyService<>(
                new AsymmetricKeyController(keyType),
                new KeyStoreController<>(),
                new KeyDestroyerController<>()
        );
    }
}
