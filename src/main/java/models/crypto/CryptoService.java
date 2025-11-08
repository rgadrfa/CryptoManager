package models.crypto;

import models.crypto.interfaces.ICryptoController;
import models.file.data.InputData;
import models.file.data.OutputData;
import models.key.intefaces.IKey;
import models.key.intefaces.IKeyController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public class CryptoService<K extends IKey, A extends ICryptoController<K>> {

    private final A cryptoAlgorithm;
    private final IKeyController<K> keyController;

    CryptoService(A cryptoAlgorithm, IKeyController<K> keyController) {
        this.cryptoAlgorithm = cryptoAlgorithm;
        this.keyController = keyController;
    }

    public K createKey(){
        return keyController.createKey();
    }

    public OutputData processEncrypt(InputData data, K key)
            throws IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException {
        return cryptoAlgorithm.encrypt(data, key);
    }

    public OutputData processDecrypt(InputData data, K key)
            throws IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException {
        return cryptoAlgorithm.decrypt(data, key);
    }
}
