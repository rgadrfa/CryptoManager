package models.key.controllers;

import models.crypto.enums.SymmetricKeyType;
import models.crypto.enums.type.SymmetricTypeEncoder;
import models.key.intefaces.IKey;
import models.key.intefaces.IKeyController;
import models.key.intefaces.IKeySingle;
import models.key.keyType.KeySingle;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * Контроллер для создания симметричных криптографических ключей.
 * Реализует интерфейс IKeyController для генерации ключей заданного алгоритма и размера.
 *
 * @see IKeyController
 * @see SymmetricTypeEncoder
 * @see KeySingle
 */
public class SymmetricKeyController implements IKeyController<IKeySingle> {
    /**
     * Генератор ключей из стандартной библиотеки JCA
     */
    private final KeyGenerator keyGenerator;
    private final int sizeKey;

    /**
     * Создает контроллер для генерации симметричных ключей указанного алгоритма.
     *
     * @param algorithm перечисление, содержащее название алгоритма и размер ключа
     * @throws NoSuchAlgorithmException если алгоритм не поддерживается в текущей среде выполнения
     */
    public SymmetricKeyController(SymmetricKeyType algorithm)
            throws NoSuchAlgorithmException {
        this.keyGenerator = KeyGenerator.getInstance(algorithm
                .getAlgorithm()
                .getAlgorithmName()
        );
        this.sizeKey = algorithm.getKeySizeBits();
    }

    /**
     * Создает новый симметричный ключ с заданными параметрами алгоритма и размера.
     *
     * @return объект IKey, содержащий сгенерированный симметричный ключ
     * @see IKey
     */
    @Override
    public IKeySingle createKey() {
        keyGenerator.init(sizeKey);
        return new KeySingle(keyGenerator.generateKey());
    }
}
