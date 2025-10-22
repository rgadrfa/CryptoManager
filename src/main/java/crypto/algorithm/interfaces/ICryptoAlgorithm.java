package crypto.algorithm.interfaces;

import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public interface ICryptoAlgorithm<K extends IKey> {

    OutputData encrypt(InputData data, K key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
    OutputData decrypt(InputData data, K key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
}
