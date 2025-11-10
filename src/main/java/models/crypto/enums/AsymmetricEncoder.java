package models.crypto.enums;

import lombok.Getter;
import models.crypto.enums.type.AsymmetricTypeEncoder;
import models.crypto.enums.padding.AsymmetricPaddingEncoder;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum AsymmetricEncoder {
    // ==================== RSA режимы ====================
    RSA_PKCS1Padding(AsymmetricTypeEncoder.RSA, AsymmetricPaddingEncoder.PKCS1Padding),
    RSA_OAEPWithSHA1AndMGF1Padding(AsymmetricTypeEncoder.RSA, AsymmetricPaddingEncoder.OAEPWithSHA1AndMGF1Padding),
    RSA_OAEPWithSHA256AndMGF1Padding(AsymmetricTypeEncoder.RSA, AsymmetricPaddingEncoder.OAEPWithSHA256AndMGF1Padding),
    RSA_OAEPWithSHA512AndMGF1Padding(AsymmetricTypeEncoder.RSA, AsymmetricPaddingEncoder.OAEPWithSHA512AndMGF1Padding),
    RSA_OAEPWithSHA384AndMGF1Padding(AsymmetricTypeEncoder.RSA, AsymmetricPaddingEncoder.OAEPWithSHA384AndMGF1Padding),
    RSA_NoPadding(AsymmetricTypeEncoder.RSA, AsymmetricPaddingEncoder.NoPadding),

    // ==================== ElGamal режимы ====================
    ELGAMAL_PKCS1Padding(AsymmetricTypeEncoder.ElGamal, AsymmetricPaddingEncoder.PKCS1Padding),
    ELGAMAL_OAEPWithSHA1AndMGF1Padding(AsymmetricTypeEncoder.ElGamal, AsymmetricPaddingEncoder.OAEPWithSHA1AndMGF1Padding),
    ELGAMAL_OAEPWithSHA256AndMGF1Padding(AsymmetricTypeEncoder.ElGamal, AsymmetricPaddingEncoder.OAEPWithSHA256AndMGF1Padding),
    ELGAMAL_NoPadding(AsymmetricTypeEncoder.ElGamal, AsymmetricPaddingEncoder.NoPadding),

    // ==================== EC/ECIES режимы ====================
    ECIES(AsymmetricTypeEncoder.EC, AsymmetricPaddingEncoder.NoPadding),
    ECIES_WithSHA1(AsymmetricTypeEncoder.EC, AsymmetricPaddingEncoder.NoPadding),
    ECIES_WithSHA256(AsymmetricTypeEncoder.EC, AsymmetricPaddingEncoder.NoPadding),
    ECIES_WithDESede(AsymmetricTypeEncoder.EC, AsymmetricPaddingEncoder.NoPadding),
    ECIES_WithAES128(AsymmetricTypeEncoder.EC, AsymmetricPaddingEncoder.NoPadding),
    ECIES_WithAES256(AsymmetricTypeEncoder.EC, AsymmetricPaddingEncoder.NoPadding);

    private final AsymmetricTypeEncoder type;
    private final AsymmetricPaddingEncoder padding;
    private final String transformation;

    AsymmetricEncoder(AsymmetricTypeEncoder type, AsymmetricPaddingEncoder padding) {
        this.type = type;
        this.padding = padding;
        this.transformation = buildTransformation();
    }

    private String buildTransformation() {
        switch (this.name()) {
            case "ECIES": return "ECIES";
            case "ECIES_WithSHA1": return "ECIESWithSHA1";
            case "ECIES_WithSHA256": return "ECIESWithSHA256";
            case "ECIES_WithDESede": return "ECIESWithDESede";
            case "ECIES_WithAES128": return "ECIESWithAES128";
            case "ECIES_WithAES256": return "ECIESWithAES256";
            default:
                // Для RSA: Algorithm/ECB/Padding
                if (type == AsymmetricTypeEncoder.RSA) {
                    if (padding != AsymmetricPaddingEncoder.NoPadding) {
                        return "RSA/ECB/" + padding.getPaddingName();
                    } else {
                        return "RSA";
                    }
                }
                // Для других алгоритмов
                else if (padding != AsymmetricPaddingEncoder.NoPadding) {
                    return type.getAlgorithmName() + "/" + padding.getPaddingName();
                } else {
                    return type.getAlgorithmName();
                }
        }
    }


    /**
     * Получает массив всех доступных типов алгоритмов
     * @return массив AsymmetricTypeEncoder
     */
    public static AsymmetricTypeEncoder[] getAvailableCipherTypes() {
        Set<AsymmetricTypeEncoder> types = Arrays.stream(values())
                .map(AsymmetricEncoder::getType)
                .collect(Collectors.toSet());
        return types.toArray(new AsymmetricTypeEncoder[0]);
    }

    /**
     * Получает массив типов дополнения для заданного типа алгоритма
     * @param cipherType тип алгоритма
     * @return массив AsymmetricPaddingEncoder с типами дополнения
     */
    public static AsymmetricPaddingEncoder[] getPaddingsForCipher(AsymmetricTypeEncoder cipherType) {
        return Arrays.stream(values())
                .filter(encoder -> encoder.getType() == cipherType)
                .map(AsymmetricEncoder::getPadding)
                .distinct()
                .toArray(AsymmetricPaddingEncoder[]::new);
    }

    /**
     * Находит соответствующий AsymmetricEncoder по компонентам
     * @param type тип алгоритма
     * @param padding тип дополнения
     * @return AsymmetricEncoder или null если не найден
     */
    public static AsymmetricEncoder findByComponents(AsymmetricTypeEncoder type, AsymmetricPaddingEncoder padding) {
        return Arrays.stream(values())
                .filter(encoder -> encoder.getType() == type && encoder.getPadding() == padding)
                .findFirst()
                .orElse(null);
    }
}