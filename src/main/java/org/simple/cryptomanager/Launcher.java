package org.simple.cryptomanager;

import crypto.CryptoService;
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

        var cryptoService = CryptoService.createSymmetric(SymmetricTypeEncoder.AES_256);
        var key = cryptoService.createKey();
    }
}
