package models.key.intefaces;

import java.security.Key;

public interface IKey extends Key{
    boolean isSymmetric();
    boolean isAsymmetric();
}
