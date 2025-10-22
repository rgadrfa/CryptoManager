package crypto.keys.intefaces;

import java.security.KeyPair;

public interface IKeyPair extends IKey {
    IPublicKey getPublicKey();
    IPrivateKey getPrivateKey();
}
