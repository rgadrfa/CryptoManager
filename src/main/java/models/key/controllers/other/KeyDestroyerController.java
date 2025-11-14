package models.key.controllers.other;

import models.key.intefaces.IKey;
import models.key.intefaces.IKeyDestroyerController;

public class KeyDestroyerController<K extends IKey> implements IKeyDestroyerController<K> {

    @Override
    public void destroyKey(K key) {

    }
}
