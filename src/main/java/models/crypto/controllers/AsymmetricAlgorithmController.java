package models.crypto.controllers;

import models.crypto.enums.AsymmetricTypeEncoder;
import models.crypto.interfaces.ICryptoController;
import models.file.data.InputData;
import models.file.data.OutputData;
import models.key.intefaces.IKeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AsymmetricAlgorithmController implements ICryptoController<IKeyPair> {

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
