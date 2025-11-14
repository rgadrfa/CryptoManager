package models.crypto.interfaces;

import models.file.data.Data;
import models.key.intefaces.IKey;

@FunctionalInterface
public interface ICryptoFunction {
    Data start(Data data, IKey key);
}
