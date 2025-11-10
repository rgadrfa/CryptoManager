package models.crypto.enums.type;

import lombok.Getter;

@Getter
public enum AsymmetricTypeEncoder {
    RSA("RSA"),
    EC("EC"),
    ElGamal("ElGamal");

    private final String algorithmName;
    AsymmetricTypeEncoder(String name) {
        this.algorithmName = name;
    }
}