package crypto.algorithm.controllers;

import crypto.algorithm.enums.AsymmetricTypeEncoder;
import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;

public class AsymmetricAlgorithmController implements ICryptoAlgorithm {

    public AsymmetricAlgorithmController(AsymmetricTypeEncoder algorithm){

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
