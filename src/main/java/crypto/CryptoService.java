package crypto;

import crypto.algorithm.controllers.AsymmetricAlgorithmController;
import crypto.algorithm.controllers.SymmetricAlgorithmController;
import crypto.algorithm.enums.AsymmetricTypeEncoder;
import crypto.algorithm.enums.SymmetricTypeEncoder;
import crypto.algorithm.interfaces.ICryptoAlgorithm;
import crypto.data.InputData;
import crypto.data.OutputData;
import crypto.keys.controllers.AsymmetricKeyController;
import crypto.keys.controllers.SymmetricKeyController;
import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeyController;

import java.security.NoSuchAlgorithmException;

public class CryptoService {
    private final ICryptoAlgorithm cryptoAlgorithm;
    private final IKeyController keyGenerator;

    private CryptoService(
            ICryptoAlgorithm algorithm,
            IKeyController keyGenerator){
        this.cryptoAlgorithm = algorithm;
        this.keyGenerator = keyGenerator;
    }

    public static CryptoService createSymmetric(SymmetricTypeEncoder algorithm) throws NoSuchAlgorithmException {
        return new CryptoService(
                new SymmetricAlgorithmController(algorithm),
                new SymmetricKeyController(algorithm)
        );
    }

    public static CryptoService createAsymmetric(AsymmetricTypeEncoder algorithm) {
        return new CryptoService(
                new AsymmetricAlgorithmController(algorithm),
                new AsymmetricKeyController(algorithm)
        );
    }

    public IKey createKey(){
        return keyGenerator.create();
    }

    public OutputData processEncrypt(InputData data, IKey key){
        return cryptoAlgorithm.encrypt(data, key);
    }

    public OutputData processDecrypt(InputData data, IKey key){
        return cryptoAlgorithm.decrypt(data, key);
    }
}
