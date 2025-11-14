package models.key;

import models.key.controllers.AsymmetricKeyController;
import models.key.controllers.SymmetricKeyController;
import models.key.controllers.other.KeyDestroyerController;
import models.key.controllers.other.KeyStoreController;
import models.key.enums.AsymmetricKeyType;
import models.key.enums.SymmetricKeyType;
import models.key.intefaces.IKeyPair;
import models.key.intefaces.IKeySingle;

import java.security.NoSuchAlgorithmException;

public class KeyServiceFactory {
    public static KeyService<IKeySingle> create(SymmetricKeyType keyType)
            throws NoSuchAlgorithmException {
        return new KeyService<>(
                new SymmetricKeyController(keyType),
                new KeyStoreController<>(),
                new KeyDestroyerController<>()
        );
    }

    public static KeyService<IKeyPair> create(AsymmetricKeyType keyType)
            throws NoSuchAlgorithmException {
        return new KeyService<>(
                new AsymmetricKeyController(keyType),
                new KeyStoreController<>(),
                new KeyDestroyerController<>()
        );
    }
}
