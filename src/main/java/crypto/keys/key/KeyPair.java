package crypto.keys.key;

import crypto.keys.intefaces.IKey;
import lombok.Getter;

public class KeyPair implements IKey {
    @Getter
    private final PublicKey publicKey;
    @Getter
    private final PrivateKey privateKey;

    public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
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
}
