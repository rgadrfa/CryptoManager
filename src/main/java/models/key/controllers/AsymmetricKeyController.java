package models.key.controllers;


import models.key.enums.AsymmetricKeyType;
import models.key.intefaces.IKeyController;
import models.key.intefaces.IKeyPair;
import models.key.keyType.KeyPair;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class AsymmetricKeyController implements IKeyController<IKeyPair> {
    private final KeyPairGenerator keyGenerator;
    private final int sizeKey;

    public AsymmetricKeyController(AsymmetricKeyType algorithm) throws NoSuchAlgorithmException {
        this.keyGenerator = KeyPairGenerator.getInstance(algorithm
                .getAlgorithm()
                .getAlgorithmName()
        );
        this.sizeKey = algorithm.getKeySizeBits();
    }

    @Override
    public IKeyPair createKey() {
        keyGenerator.initialize(sizeKey);
        java.security.KeyPair keyPair = keyGenerator.generateKeyPair();
        return new KeyPair(
                keyPair.getPublic(),
                keyPair.getPrivate()
        );
    }
}
