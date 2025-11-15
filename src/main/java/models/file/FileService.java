package models.file;

import lombok.SneakyThrows;
import models.crypto.CryptoAlgorithmService;
import models.crypto.interfaces.IAlgorithmController;
import models.file.controllers.DataController;
import models.file.controllers.FileController;
import models.file.controllers.FilePathController;
import models.file.data.Data;
import models.file.interfaces.IDataController;
import models.file.interfaces.IFileController;
import models.file.interfaces.IFilePathController;
import models.key.intefaces.IKeyPair;
import models.key.intefaces.IKeySingle;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.function.BiFunction;

public class FileService {

    private final IFilePathController pathController;
    private final IDataController dataController;
    private final IFileController fileController;

    public FileService() {
        this.pathController = new FilePathController();
        this.dataController = new DataController();
        this.fileController = new FileController();
    }

    public void setFirstPath(String path){
        pathController.setFirstPath(path);
    }

    public void setSecondPath(String path){
        fileController.createFile(path);
        pathController.setSecondPath(path);
    }

    public <T> void process(ThrowingBiFunction<Data,T,Data> function,T key){
        try {
            String sourcePath = pathController.getFirstPath();
            String targetPath = pathController.getSecondPath();

            Data inputData = dataController.readData(sourcePath);
            Data outputData = function.apply(inputData, key);
            dataController.writeData(targetPath, outputData);

            System.gc();
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    @FunctionalInterface
    public interface ThrowingBiFunction<T, U, R> {
        R apply(T t, U u) throws Exception;
    }

    public void encrypt(CryptoAlgorithmService<IKeySingle, IAlgorithmController<IKeySingle>> cryptoService, IKeySingle key) {
        process(
                cryptoService::processEncrypt,
                key
        );
    }

    public void encrypt(CryptoAlgorithmService<IKeyPair, IAlgorithmController<IKeyPair>> cryptoService, PublicKey publicKey) {
        process(
                cryptoService::encryptWithPublicKey,
                publicKey
        );
    }

    // Методы для дешифрования
    public void decrypt(CryptoAlgorithmService<IKeySingle, IAlgorithmController<IKeySingle>> cryptoService, IKeySingle key) {
        process(
                cryptoService::processDecrypt,
                key
        );
    }

    public void decrypt(CryptoAlgorithmService<IKeyPair, IAlgorithmController<IKeyPair>> cryptoService, PrivateKey privateKey) {
        process(
                cryptoService::decryptWithPrivateKey,
                privateKey
        );
    }
}
