package models.crypto.interfaces;

import models.file.data.InputData;
import models.file.data.OutputData;
import models.key.intefaces.IKeySingle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public interface ISymmetricController  extends IAlgorithmController<IKeySingle> {
    OutputData encrypt(InputData data, IKeySingle key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;

    OutputData decrypt(InputData data, IKeySingle key)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;
}

