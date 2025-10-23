package crypto.keys.key;

import crypto.keys.intefaces.IKeySingle;

import javax.crypto.SecretKey;

public class KeySingle implements IKeySingle {
    private final SecretKey key;

    public KeySingle(SecretKey key) {
        this.key = key;
    }

    @Override
    public boolean isSymmetric() {
        return false;
    }

    @Override
    public boolean isAsymmetric() {
        return false;
    }

    @Override
    public String getAlgorithm() {
        return "";
    }

    @Override
    public String getFormat() {
        return "";
    }

    @Override
    public byte[] getEncoded() {
        return new byte[0];
    }

    @Override
    public SecretKey getSecretKey() {
        return key;
    }
}
