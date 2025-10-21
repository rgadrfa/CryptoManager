package org.simple.cryptomanager;

import crypto.CryptoService;
import crypto.algorithm.enums.SymmetricTypeEncoder;
import javafx.application.Application;

import java.security.NoSuchAlgorithmException;

public class Launcher {
    public static void main(String[] args)
            throws NoSuchAlgorithmException {
        //Application.launch(HelloApplication.class, args);

        var cryptoService = CryptoService.createSymmetric(SymmetricTypeEncoder.AES_256);
        var key = cryptoService.createKey();
    }
}
