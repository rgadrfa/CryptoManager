package models.key.enums;

import lombok.Getter;
import models.crypto.enums.type.SymmetricTypeEncoder;

@Getter
public enum SymmetricKeyType {
    // AES ключи
    AES_128(SymmetricTypeEncoder.AES, "128", 128),
    AES_192(SymmetricTypeEncoder.AES, "192", 192),
    AES_256(SymmetricTypeEncoder.AES, "256", 256),

    // DES ключи
    DES_56(SymmetricTypeEncoder.DES, "56", 56),

    // 3DES ключи
    DESEDE_112(SymmetricTypeEncoder.DESede, "112", 112),
    DESEDE_168(SymmetricTypeEncoder.DESede, "168", 168),

    // Blowfish ключи
    BLOWFISH_128(SymmetricTypeEncoder.Blowfish, "128", 128),
    BLOWFISH_256(SymmetricTypeEncoder.Blowfish, "256", 256),
    BLOWFISH_448(SymmetricTypeEncoder.Blowfish, "448", 448);

    private final SymmetricTypeEncoder algorithm;
    private final String keySize;
    private final int keySizeBits;

    SymmetricKeyType(SymmetricTypeEncoder algorithm, String keySize, int keySizeBits) {
        this.algorithm = algorithm;
        this.keySize = keySize;
        this.keySizeBits = keySizeBits;
    }
}