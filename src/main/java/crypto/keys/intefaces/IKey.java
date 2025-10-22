package crypto.keys.intefaces;

import javax.crypto.SecretKey;
import java.security.Key;

public interface IKey extends Key{

    boolean isSymmetric();
    boolean isAsymmetric();

}
