package models.key.enums;

import lombok.Getter;
import models.crypto.enums.type.AsymmetricTypeEncoder;

@Getter
public enum AsymmetricKeyType {
    // RSA ключи
    RSA_1024(AsymmetricTypeEncoder.RSA, "1024", 1024),
    RSA_2048(AsymmetricTypeEncoder.RSA, "2048", 2048),
    RSA_3072(AsymmetricTypeEncoder.RSA, "3072", 3072),
    RSA_4096(AsymmetricTypeEncoder.RSA, "4096", 4096),

    // EC (Elliptic Curve) ключи
    EC_256(AsymmetricTypeEncoder.EC, "256", 256),
    EC_384(AsymmetricTypeEncoder.EC, "384", 384),
    EC_521(AsymmetricTypeEncoder.EC, "521", 521),

    // ElGamal ключи
    ELGAMAL_1024(AsymmetricTypeEncoder.ElGamal, "1024", 1024),
    ELGAMAL_2048(AsymmetricTypeEncoder.ElGamal, "2048", 2048),
    ELGAMAL_3072(AsymmetricTypeEncoder.ElGamal, "3072", 3072),
    ELGAMAL_4096(AsymmetricTypeEncoder.ElGamal, "4096", 4096);

    private final AsymmetricTypeEncoder algorithm;
    private final String keySize;
    private final int keySizeBits;

    AsymmetricKeyType(AsymmetricTypeEncoder algorithm, String keySize, int keySizeBits) {
        this.algorithm = algorithm;
        this.keySize = keySize;
        this.keySizeBits = keySizeBits;
    }
}
