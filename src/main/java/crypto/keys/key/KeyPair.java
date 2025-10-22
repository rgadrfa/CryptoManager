package crypto.keys.key;

import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeyPair;
import crypto.keys.intefaces.IPrivateKey;
import crypto.keys.intefaces.IPublicKey;
import lombok.Getter;

import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyPair implements IKeyPair {

    private final PublicKey publicKey;

    private final PrivateKey privateKey;

    public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
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
    public PublicKey getPublicKey() {
        return publicKey;
    }

    @Override
    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
