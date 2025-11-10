package models.crypto.enums;

import lombok.Getter;
import models.crypto.enums.type.SymmetricTypeEncoder;
import models.crypto.enums.mode.SymmetricModeEncoder;
import models.crypto.enums.padding.SymmetricPaddingEncoder;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum SymmetricEncoder {
    // ==================== AES режимы ====================
    // ECB режимы
    AES_ECB_PKCS5Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.PKCS5Padding),
    AES_ECB_PKCS7Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.PKCS7Padding),
    AES_ECB_ISO10126Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.ISO10126Padding),
    AES_ECB_NoPadding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.NoPadding),

    // CBC режимы
    AES_CBC_PKCS5Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.PKCS5Padding),
    AES_CBC_PKCS7Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.PKCS7Padding),
    AES_CBC_ISO10126Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.ISO10126Padding),
    AES_CBC_NoPadding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.NoPadding),

    // CFB режимы
    AES_CFB_PKCS5Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.PKCS5Padding),
    AES_CFB_PKCS7Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.PKCS7Padding),
    AES_CFB_ISO10126Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.ISO10126Padding),
    AES_CFB_NoPadding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.NoPadding),

    // OFB режимы
    AES_OFB_PKCS5Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.PKCS5Padding),
    AES_OFB_PKCS7Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.PKCS7Padding),
    AES_OFB_ISO10126Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.ISO10126Padding),
    AES_OFB_NoPadding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.NoPadding),

    // CTR режим
    AES_CTR_NoPadding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CTR, SymmetricPaddingEncoder.NoPadding),

    // GCM режим
    AES_GCM_NoPadding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.GCM, SymmetricPaddingEncoder.NoPadding),

    // CCM режим
    AES_CCM_NoPadding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.CCM, SymmetricPaddingEncoder.NoPadding),

    // PCBC режимы
    AES_PCBC_PKCS5Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.PKCS5Padding),
    AES_PCBC_PKCS7Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.PKCS7Padding),
    AES_PCBC_ISO10126Padding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.ISO10126Padding),
    AES_PCBC_NoPadding(SymmetricTypeEncoder.AES, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.NoPadding),

    // ==================== DES режимы ====================
    // ECB режимы
    DES_ECB_PKCS5Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.PKCS5Padding),
    DES_ECB_PKCS7Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.PKCS7Padding),
    DES_ECB_ISO10126Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.ISO10126Padding),
    DES_ECB_NoPadding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.NoPadding),

    // CBC режимы
    DES_CBC_PKCS5Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.PKCS5Padding),
    DES_CBC_PKCS7Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.PKCS7Padding),
    DES_CBC_ISO10126Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.ISO10126Padding),
    DES_CBC_NoPadding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.NoPadding),

    // CFB режимы
    DES_CFB_PKCS5Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.PKCS5Padding),
    DES_CFB_PKCS7Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.PKCS7Padding),
    DES_CFB_ISO10126Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.ISO10126Padding),
    DES_CFB_NoPadding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.NoPadding),

    // OFB режимы
    DES_OFB_PKCS5Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.PKCS5Padding),
    DES_OFB_PKCS7Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.PKCS7Padding),
    DES_OFB_ISO10126Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.ISO10126Padding),
    DES_OFB_NoPadding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.NoPadding),

    // PCBC режимы
    DES_PCBC_PKCS5Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.PKCS5Padding),
    DES_PCBC_PKCS7Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.PKCS7Padding),
    DES_PCBC_ISO10126Padding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.ISO10126Padding),
    DES_PCBC_NoPadding(SymmetricTypeEncoder.DES, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.NoPadding),

    // ==================== DESede (3DES) режимы ====================
    // ECB режимы
    DESede_ECB_PKCS5Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.PKCS5Padding),
    DESede_ECB_PKCS7Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.PKCS7Padding),
    DESede_ECB_ISO10126Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.ISO10126Padding),
    DESede_ECB_NoPadding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.NoPadding),

    // CBC режимы
    DESede_CBC_PKCS5Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.PKCS5Padding),
    DESede_CBC_PKCS7Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.PKCS7Padding),
    DESede_CBC_ISO10126Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.ISO10126Padding),
    DESede_CBC_NoPadding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.NoPadding),

    // CFB режимы
    DESede_CFB_PKCS5Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.PKCS5Padding),
    DESede_CFB_PKCS7Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.PKCS7Padding),
    DESede_CFB_ISO10126Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.ISO10126Padding),
    DESede_CFB_NoPadding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.NoPadding),

    // OFB режимы
    DESede_OFB_PKCS5Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.PKCS5Padding),
    DESede_OFB_PKCS7Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.PKCS7Padding),
    DESede_OFB_ISO10126Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.ISO10126Padding),
    DESede_OFB_NoPadding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.NoPadding),

    // PCBC режимы
    DESede_PCBC_PKCS5Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.PKCS5Padding),
    DESede_PCBC_PKCS7Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.PKCS7Padding),
    DESede_PCBC_ISO10126Padding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.ISO10126Padding),
    DESede_PCBC_NoPadding(SymmetricTypeEncoder.DESede, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.NoPadding),

    // ==================== Blowfish режимы ====================
    // ECB режимы
    Blowfish_ECB_PKCS5Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.PKCS5Padding),
    Blowfish_ECB_PKCS7Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.PKCS7Padding),
    Blowfish_ECB_ISO10126Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.ISO10126Padding),
    Blowfish_ECB_NoPadding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.ECB, SymmetricPaddingEncoder.NoPadding),

    // CBC режимы
    Blowfish_CBC_PKCS5Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.PKCS5Padding),
    Blowfish_CBC_PKCS7Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.PKCS7Padding),
    Blowfish_CBC_ISO10126Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.ISO10126Padding),
    Blowfish_CBC_NoPadding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.CBC, SymmetricPaddingEncoder.NoPadding),

    // CFB режимы
    Blowfish_CFB_PKCS5Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.PKCS5Padding),
    Blowfish_CFB_PKCS7Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.PKCS7Padding),
    Blowfish_CFB_ISO10126Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.ISO10126Padding),
    Blowfish_CFB_NoPadding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.CFB, SymmetricPaddingEncoder.NoPadding),

    // OFB режимы
    Blowfish_OFB_PKCS5Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.PKCS5Padding),
    Blowfish_OFB_PKCS7Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.PKCS7Padding),
    Blowfish_OFB_ISO10126Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.ISO10126Padding),
    Blowfish_OFB_NoPadding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.OFB, SymmetricPaddingEncoder.NoPadding),

    // PCBC режимы
    Blowfish_PCBC_PKCS5Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.PKCS5Padding),
    Blowfish_PCBC_PKCS7Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.PKCS7Padding),
    Blowfish_PCBC_ISO10126Padding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.ISO10126Padding),
    Blowfish_PCBC_NoPadding(SymmetricTypeEncoder.Blowfish, SymmetricModeEncoder.PCBC, SymmetricPaddingEncoder.NoPadding);

    private final SymmetricTypeEncoder type;
    private final SymmetricModeEncoder mode;
    private final SymmetricPaddingEncoder padding;
    private final String transformation;

    SymmetricEncoder(SymmetricTypeEncoder type, SymmetricModeEncoder mode, SymmetricPaddingEncoder padding) {
        this.type = type;
        this.mode = mode;
        this.padding = padding;
        this.transformation = type.getAlgorithmName() + "/" + mode.getModeName() + "/" + padding.getPaddingName();
    }

    /**
     * Получает массив всех доступных типов шифров
     * @return массив SymmetricTypeEncoder
     */
    public static SymmetricTypeEncoder[] getAvailableCipherTypes() {
        Set<SymmetricTypeEncoder> types = Arrays.stream(values())
                .map(SymmetricEncoder::getType)
                .collect(Collectors.toSet());
        return types.toArray(new SymmetricTypeEncoder[0]);
    }

    /**
     * Получает массив режимов для заданного типа шифра
     * @param cipherType тип шифра
     * @return массив SymmetricModeEncoder с режимами шифрования
     */
    public static SymmetricModeEncoder[] getModesForCipher(SymmetricTypeEncoder cipherType) {
        return Arrays.stream(values())
                .filter(mode -> mode.getType() == cipherType)
                .map(SymmetricEncoder::getMode)
                .distinct()
                .toArray(SymmetricModeEncoder[]::new);
    }

    /**
     * Получает массив типов дополнения для заданного режима шифра
     * @param cipherType тип шифра
     * @param mode режим шифрования
     * @return массив SymmetricPaddingEncoder с типами дополнения
     */
    public static SymmetricPaddingEncoder[] getPaddingsForCipherMode(SymmetricTypeEncoder cipherType, SymmetricModeEncoder mode) {
        return Arrays.stream(values())
                .filter(encoder -> encoder.getType() == cipherType && encoder.getMode() == mode)
                .map(SymmetricEncoder::getPadding)
                .distinct()
                .toArray(SymmetricPaddingEncoder[]::new);
    }

    /**
     * Находит соответствующий SymmetricEncoder по компонентам
     * @param type тип шифра
     * @param mode режим шифрования
     * @param padding тип дополнения
     * @return SymmetricEncoder или null если не найден
     */
    public static SymmetricEncoder findByComponents(SymmetricTypeEncoder type, SymmetricModeEncoder mode, SymmetricPaddingEncoder padding) {
        return Arrays.stream(values())
                .filter(encoder -> encoder.getType() == type &&
                        encoder.getMode() == mode &&
                        encoder.getPadding() == padding)
                .findFirst()
                .orElse(null);
    }
}
