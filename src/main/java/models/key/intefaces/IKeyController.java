package models.key.intefaces;

public interface IKeyController<K extends IKey>  {
    K createKey();
}
