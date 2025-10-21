package crypto.algorithm.controllers;

import crypto.algorithm.enums.SymmetricTypeEncoder;
import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;

public class SymmetricAlgorithmController implements ICryptoAlgorithm {

    public SymmetricAlgorithmController(SymmetricTypeEncoder algorithm) {

    }

    @Override
    public OutputData encrypt(InputData data, IKey key) {
        return null;
    }

    @Override
    public OutputData decrypt(InputData data, IKey key) {
        return null;
    }
}
