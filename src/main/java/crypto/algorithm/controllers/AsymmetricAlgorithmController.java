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
import java.util.function.Function;

public class AsymmetricAlgorithmController implements ICryptoAlgorithm<IKeyPair> {

    private final Cipher cipher;

    public AsymmetricAlgorithmController(AsymmetricTypeEncoder algorithm)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(algorithm.getAlgorithmName());
    }

    @Override
    public OutputData encrypt(InputData data, IKeyPair key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, key.getPublicKey());
        return new OutputData(cipher.doFinal(data.getInputData()));
    }

    @Override
    public OutputData decrypt(InputData data, IKeyPair key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, key.getPrivateKey());
        return new OutputData(cipher.doFinal(data.getInputData()));
    }
}
