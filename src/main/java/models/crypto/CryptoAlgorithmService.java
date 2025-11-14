package models.crypto;

import models.crypto.interfaces.IAlgorithmController;
import models.crypto.interfaces.IAsymmetricController;
import models.crypto.interfaces.ISymmetricController;
import models.file.data.Data;
import models.key.intefaces.IKey;
import models.key.intefaces.IKeySingle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class CryptoAlgorithmService<K extends IKey, A extends IAlgorithmController<K>> {
    private final A cryptoAlgorithm;

    CryptoAlgorithmService(A cryptoAlgorithm) {
        this.cryptoAlgorithm = cryptoAlgorithm;
    }

    public Data processEncrypt(Data data, K key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        if (cryptoAlgorithm instanceof ISymmetricController && key instanceof IKeySingle) {
            return ((ISymmetricController) cryptoAlgorithm).encrypt(data, (IKeySingle) key);
        }

        throw new UnsupportedOperationException();
    }

    public Data processDecrypt(Data data, K key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        if (cryptoAlgorithm instanceof ISymmetricController && key instanceof IKeySingle) {
            return ((ISymmetricController) cryptoAlgorithm).decrypt(data, (IKeySingle) key);
        }

        throw new UnsupportedOperationException();
    }

    // Специализированные методы для асимметричного шифрования
    public Data encryptWithPublicKey(Data data, PublicKey publicKey)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        if (cryptoAlgorithm instanceof IAsymmetricController) {
            return ((IAsymmetricController) cryptoAlgorithm).encrypt(data, publicKey);
        }

        throw new UnsupportedOperationException();
    }

    public Data decryptWithPrivateKey(Data data, PrivateKey privateKey)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        if (cryptoAlgorithm instanceof IAsymmetricController) {
            return ((IAsymmetricController)cryptoAlgorithm).decrypt(data, privateKey);
        }

        throw new UnsupportedOperationException();
    }
}
