package models.crypto.interfaces;

import models.file.data.InputData;
import models.file.data.OutputData;
import models.key.intefaces.IKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public interface ICryptoController<K extends IKey> {

    OutputData encrypt(InputData data, K key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
    OutputData decrypt(InputData data, K key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
}
