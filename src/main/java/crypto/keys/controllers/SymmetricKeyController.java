package crypto.keys.controllers;

import crypto.algorithm.enums.SymmetricTypeEncoder;
import crypto.data.OutputData;
import crypto.keys.intefaces.IKey;
import crypto.keys.intefaces.IKeyController;
import crypto.keys.intefaces.IKeySingle;
import crypto.keys.key.KeySingle;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
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
    /**
     * Размер генерируемого ключа в битах
     */
    private final int sizeKey;

    /**
     * Создает контроллер для генерации симметричных ключей указанного алгоритма.
     *
     * @param algorithm перечисление, содержащее название алгоритма и размер ключа
     * @throws NoSuchAlgorithmException если алгоритм не поддерживается в текущей среде выполнения
     */
    public SymmetricKeyController(SymmetricTypeEncoder algorithm) throws NoSuchAlgorithmException {
        this.keyGenerator = KeyGenerator.getInstance(algorithm.getAlgorithmName());
        this.sizeKey = algorithm.getKeySize();
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
