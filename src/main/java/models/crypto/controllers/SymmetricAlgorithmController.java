package models.crypto.controllers;

import models.crypto.enums.SymmetricEncoder;
import models.crypto.interfaces.ISymmetricController;
import models.file.data.Data;
import models.key.intefaces.IKeySingle;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SymmetricAlgorithmController implements ISymmetricController {

    private final Cipher cipher;

    public SymmetricAlgorithmController(SymmetricEncoder algorithm)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(algorithm.getTransformation());
    }

    public Data decode(Data data, IKeySingle key, int mode)
            throws InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        cipher.init(mode, key.getSecretKey());
        return new Data(cipher.doFinal(data.getInputData()));
    }

    @Override
    public Data encrypt(Data data, IKeySingle key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return decode(data,key,Cipher.ENCRYPT_MODE);
    }

    @Override
    public Data decrypt(Data data, IKeySingle key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return decode(data,key,Cipher.DECRYPT_MODE);
    }
}
