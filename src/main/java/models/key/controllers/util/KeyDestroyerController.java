package models.key.controllers.util;

import models.key.intefaces.IKey;
import models.key.intefaces.IKeyController;
import models.key.intefaces.IKeyDestroyerController;

public class KeyDestroyerController<K extends IKey> implements IKeyDestroyerController<K> {

    @Override
    public void destroyKey(K key) {

    }
}
