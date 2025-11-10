package models.crypto.interfaces;

import models.file.data.InputData;
import models.file.data.OutputData;
import models.key.intefaces.IKeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface IAsymmetricController extends IAlgorithmController<IKeyPair>{
    OutputData encrypt(InputData data, PublicKey key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;

    OutputData decrypt(InputData data, PrivateKey key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;
}
