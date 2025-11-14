package models.crypto.interfaces;

import models.file.data.Data;
import models.key.intefaces.IKeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface IAsymmetricController extends IAlgorithmController<IKeyPair>{
    Data encrypt(Data data, PublicKey key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;

    Data decrypt(Data data, PrivateKey key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;
}
