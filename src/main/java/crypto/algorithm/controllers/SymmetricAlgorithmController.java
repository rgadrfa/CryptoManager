package crypto.algorithm.controllers;

import crypto.algorithm.enums.SymmetricTypeEncoder;
import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeySingle;
import crypto.keys.key.KeySingle;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class SymmetricAlgorithmController implements ICryptoAlgorithm<IKeySingle> {

    private final Cipher cipher;

    public SymmetricAlgorithmController(SymmetricTypeEncoder algorithm)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(algorithm.getAlgorithmName());
    }

    public OutputData decode(InputData data, IKeySingle key, int mode)
            throws InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        cipher.init(mode, key.getSecretKey());
        return new OutputData(cipher.doFinal(data.getInputData()));
    }

    @Override
    public OutputData encrypt(InputData data, IKeySingle key)
            throws InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        return decode(data,key,Cipher.ENCRYPT_MODE);
    }

    @Override
    public OutputData decrypt(InputData data, IKeySingle key)
            throws InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        return decode(data,key,Cipher.DECRYPT_MODE);
    }
}
