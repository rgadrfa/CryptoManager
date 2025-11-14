package app;

import models.crypto.CryptoServiceFactory;
import models.crypto.enums.SymmetricEncoder;
import models.file.FileService;
import models.key.KeyServiceFactory;
import models.key.enums.SymmetricKeyType;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        new Application();
    }
}