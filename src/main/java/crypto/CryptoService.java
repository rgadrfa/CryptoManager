package crypto;

import crypto.algorithm.controllers.AsymmetricAlgorithmController;
import crypto.algorithm.controllers.SymmetricAlgorithmController;
import crypto.algorithm.enums.AsymmetricTypeEncoder;
import crypto.algorithm.enums.SymmetricTypeEncoder;
import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.controllers.AsymmetricKeyController;
import crypto.keys.controllers.SymmetricKeyController;
import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeyController;
import crypto.keys.intefaces.IKeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptoService {
    private final ICryptoAlgorithm cryptoAlgorithm;
    private final IKeyController keyController;

    private CryptoService(
            ICryptoAlgorithm algorithm,
            IKeyController keyController){
        this.cryptoAlgorithm = algorithm;
        this.keyController = keyController;
    }

    public static CryptoService createSymmetric(SymmetricTypeEncoder algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return new CryptoService(
                new SymmetricAlgorithmController(algorithm),
                new SymmetricKeyController(algorithm)
        );
    }

    public static CryptoService createAsymmetric(AsymmetricTypeEncoder algorithm)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        return new CryptoService(
                new AsymmetricAlgorithmController(algorithm),
                new AsymmetricKeyController(algorithm)
        );
    }

    public IKey createKey(){
        return keyController.createKey();
    }

    public OutputData processEncrypt(InputData data, IKeyPair key)
            throws IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException {
        return cryptoAlgorithm.encrypt(data, key);
    }

    public OutputData processDecrypt(InputData data, IKey key)
            throws IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException {
        return cryptoAlgorithm.decrypt(data, key);
    }
}
