package crypto.algorithm.enums;

public enum SymmetricTypeEncoder {
    AES("AES",256),
    AES_256("AES",256),
    DES("DES",256);

    private final String algorithmName;
    private final int keySize;
    SymmetricTypeEncoder(String name, int size) {
        this.algorithmName = name;
        this.keySize = size;
    }
    public String getAlgorithmName() { return algorithmName; }
    public int getKeySize() { return keySize; }
}
