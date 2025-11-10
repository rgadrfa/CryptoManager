package models.crypto.controllers;

import models.crypto.enums.AsymmetricEncoder;
import models.crypto.enums.type.AsymmetricTypeEncoder;
import models.crypto.enums.mode.AsymmetricModeEncoder;
import models.crypto.interfaces.IAsymmetricController;
import models.file.data.InputData;
import models.file.data.OutputData;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class AsymmetricAlgorithmController implements IAsymmetricController {

    private final Cipher cipher;

    public AsymmetricAlgorithmController(AsymmetricEncoder algorithm)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(algorithm.getTransformation());
    }

    @Override
    public OutputData encrypt(InputData data, PublicKey key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new OutputData(cipher.doFinal(data.getInputData()));
    }

    @Override
    public OutputData decrypt(InputData data, PrivateKey key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new OutputData(cipher.doFinal(data.getInputData()));
    }
}
