package models.key.intefaces;

public interface IKeyDestroyerController<K extends IKey> {
    void destroyKey(K key);
}
