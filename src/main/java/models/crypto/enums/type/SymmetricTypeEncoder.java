package models.crypto.enums.type;

import lombok.Getter;

@Getter
public enum SymmetricTypeEncoder {
    AES("AES"),
    DES("DES"),
    DESede("DESede"),
    Blowfish("Blowfish");

    private final String algorithmName;
    SymmetricTypeEncoder(String algorithm) {
        this.algorithmName = algorithm;
    }
}
