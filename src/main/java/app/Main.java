package app;

import models.crypto.CryptoServiceFactory;
import models.crypto.enums.AsymmetricEncoder;
import models.crypto.enums.SymmetricEncoder;
import models.crypto.enums.SymmetricKeyType;
import models.crypto.enums.type.SymmetricTypeEncoder;
import models.crypto.enums.mode.SymmetricModeEncoder;
import models.key.KeyServiceFactory;
import models.key.enums.AsymmetricKeyType;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {
        new Application();
        var t = KeyServiceFactory.createAsymmetricKeyService(AsymmetricKeyType.RSA_1024);
        var g = CryptoServiceFactory.createAsymmetric(AsymmetricEncoder.RSA_OAEPWithSHA1AndMGF1Padding);
        g.setKeyService(t);
    }
}
