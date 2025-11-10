package models.key.intefaces;

public interface IKeyStoreController<K extends IKey> {
    void storeKey(K key, String identifier);
    K retrieveKey(String identifier);
}
