package crypto.algorithm.controllers;

import crypto.algorithm.enums.AsymmetricTypeEncoder;
import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AsymmetricAlgorithmController implements ICryptoAlgorithm {

    private final Cipher cipher;

    public AsymmetricAlgorithmController(AsymmetricTypeEncoder algorithm)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(algorithm.getAlgorithmName());
    }

    @Override
    public OutputData encrypt(InputData data, IKey key)
            throws InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        var g = (IKeyPair)key;
        cipher.init(Cipher.ENCRYPT_MODE, g.getPublicKey());
        return new OutputData(cipher.doFinal(data.getInputData()));
    }

    @Override
    public OutputData decrypt(InputData data, IKey key) {
        return null;
    }
}
