package crypto.algorithm.controllers;

import crypto.algorithm.enums.SymmetricTypeEncoder;
import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class SymmetricAlgorithmController implements ICryptoAlgorithm {

    private final Cipher cipher;

    public SymmetricAlgorithmController(SymmetricTypeEncoder algorithm)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(algorithm.getAlgorithmName());
    }

    @Override
    public OutputData encrypt(InputData data, IKey key)
            throws InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {

        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new OutputData(cipher.doFinal(data.getInputData()));
    }

    @Override
    public OutputData decrypt(InputData data, IKey key)
            throws InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new OutputData(cipher.doFinal(data.getInputData()));
    }
}
