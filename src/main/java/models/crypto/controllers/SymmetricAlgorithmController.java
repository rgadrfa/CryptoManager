package models.crypto.controllers;

import models.crypto.enums.SymmetricEncoder;
import models.crypto.enums.type.SymmetricTypeEncoder;
import models.crypto.enums.mode.SymmetricModeEncoder;
import models.crypto.interfaces.ISymmetricController;
import models.file.data.InputData;
import models.file.data.OutputData;
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

    public OutputData decode(InputData data, IKeySingle key, int mode)
            throws InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        cipher.init(mode, key.getSecretKey());
        return new OutputData(cipher.doFinal(data.getInputData()));
    }

    @Override
    public OutputData encrypt(InputData data, IKeySingle key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return decode(data,key,Cipher.ENCRYPT_MODE);
    }

    @Override
    public OutputData decrypt(InputData data, IKeySingle key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return decode(data,key,Cipher.DECRYPT_MODE);
    }
}
