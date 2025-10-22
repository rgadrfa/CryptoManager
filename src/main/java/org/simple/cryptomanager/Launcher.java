package org.simple.cryptomanager;

import crypto.CryptoService;
import crypto.algorithm.enums.AsymmetricTypeEncoder;
import crypto.algorithm.enums.SymmetricTypeEncoder;
import crypto.data.InputData;
import javafx.application.Application;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Launcher {
    public static void main(String[] args)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        //Application.launch(HelloApplication.class, args);

        var cryptoService = CryptoService.createAsymmetric(AsymmetricTypeEncoder.RSA);
        var key = cryptoService.createKey();
        var inputData = new InputData("Hello World".getBytes());
        var encryptedData = cryptoService.processEncrypt(inputData, key);
    }
}
