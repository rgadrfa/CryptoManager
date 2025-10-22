package crypto.keys.controllers;

import crypto.algorithm.enums.AsymmetricTypeEncoder;
import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeyController;
import crypto.keys.key.KeyPair;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class AsymmetricKeyController implements IKeyController {
    private final KeyPairGenerator keyGenerator;
    private final int sizeKey;

    public AsymmetricKeyController(AsymmetricTypeEncoder algorithm) throws NoSuchAlgorithmException {
        this.keyGenerator = KeyPairGenerator.getInstance(algorithm.getAlgorithmName());
        this.sizeKey = algorithm.getKeySize();
    }
    @Override
    public IKey createKey() {
        keyGenerator.initialize(sizeKey);
        java.security.KeyPair keyPair = keyGenerator.generateKeyPair();
        return new KeyPair(
                keyPair.getPublic(),
                keyPair.getPrivate()
        );
    }
}
