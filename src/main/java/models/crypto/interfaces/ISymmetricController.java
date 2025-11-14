package models.crypto.interfaces;

import models.file.data.Data;
import models.key.intefaces.IKeySingle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public interface ISymmetricController  extends IAlgorithmController<IKeySingle> {
    Data encrypt(Data data, IKeySingle key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;

    Data decrypt(Data data, IKeySingle key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;
}

