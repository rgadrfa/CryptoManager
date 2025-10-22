package crypto.keys.intefaces;

import javax.crypto.SecretKey;

public interface IKeySingle extends IKey, SecretKey {
    SecretKey getSecretKey();
}
