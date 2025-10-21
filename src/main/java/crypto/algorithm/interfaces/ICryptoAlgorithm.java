package crypto.algorithm.interfaces;

import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;

public interface ICryptoAlgorithm {

    OutputData encrypt(InputData data, IKey key);
    OutputData decrypt(InputData data, IKey key);
}
