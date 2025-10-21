package crypto.keys.controllers;

import crypto.algorithm.enums.AsymmetricTypeEncoder;
import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeyController;

public class AsymmetricKeyController implements IKeyController {
    private byte[] publicKey;
    private byte[] privateKey;

    public AsymmetricKeyController(AsymmetricTypeEncoder algorithm){

    }
    @Override
    public IKey create() {
        return null;
    }
}
