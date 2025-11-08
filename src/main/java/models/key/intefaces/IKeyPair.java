package models.key.intefaces;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface IKeyPair extends IKey {
    PublicKey getPublicKey();
    PrivateKey getPrivateKey();
}
