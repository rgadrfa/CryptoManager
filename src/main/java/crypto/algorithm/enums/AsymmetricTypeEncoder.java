package crypto.algorithm.enums;

public enum AsymmetricTypeEncoder {
    RSA("RSA",1024);

    private final String algorithmName;
    private final int keySize;
    AsymmetricTypeEncoder(String name, int size) {
        this.algorithmName = name;
        this.keySize = size;
    }
    public String getAlgorithmName() { return algorithmName; }
    public int getKeySize() { return keySize; }
}
