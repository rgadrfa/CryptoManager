package crypto.keys.intefaces;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface IKeyPair extends IKey {
    PublicKey getPublicKey();
    PrivateKey getPrivateKey();
}
