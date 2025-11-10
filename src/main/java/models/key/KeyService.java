package models.key;


import lombok.Getter;
import models.key.intefaces.IKey;
import models.key.intefaces.IKeyController;
import models.key.intefaces.IKeyDestroyerController;
import models.key.intefaces.IKeyStoreController;

@Getter
public class KeyService<K extends IKey> {
    private final IKeyController<K> keyController;
    private final IKeyStoreController<K> keyStore;
    private final IKeyDestroyerController<K> keyDestroyer;

    public KeyService(IKeyController<K> keyController, IKeyStoreController<K> keyStore, IKeyDestroyerController<K> keyDestroyer) {
        this.keyController = keyController;
        this.keyStore = keyStore;
        this.keyDestroyer = keyDestroyer;
    }
}
