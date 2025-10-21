package crypto.keys.key;

import crypto.keys.intefaces.IKey;
import lombok.Getter;

import javax.crypto.SecretKey;

public class KeySingle implements IKey {

    private final SecretKey key;

    public KeySingle(SecretKey key) {
        this.key = key;
    }

    @Override
    public String getAlgorithm() {
        return key.getAlgorithm();
    }

    @Override
    public String getFormat() {
        return key.getFormat();
    }

    @Override
    public byte[] getEncoded() {
        return key.getEncoded();
    }
}
