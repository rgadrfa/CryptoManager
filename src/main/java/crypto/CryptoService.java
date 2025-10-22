package crypto;

import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeyController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public class CryptoService<K extends IKey, A extends ICryptoAlgorithm<K>> {

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
