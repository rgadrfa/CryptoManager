package models.key.controllers.other;

import models.key.intefaces.IKey;
import models.key.intefaces.IKeyStoreController;

public class KeyStoreController<K extends IKey> implements IKeyStoreController<K> {
    @Override
    public void storeKey(K key, String identifier) {

    }

    @Override
    public K retrieveKey(String identifier) {
        return null;
    }
}
