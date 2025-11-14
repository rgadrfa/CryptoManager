package models.file;

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


    public void encrypt(CryptoAlgorithmService<IKeySingle, IAlgorithmController<IKeySingle>> cryptoService, IKeySingle key) {
        try {
            String sourcePath = pathController.getFirstPath();
            String targetPath = pathController.getSecondPath();

            Data inputData = dataController.readData(sourcePath);
            Data outputData = cryptoService.processEncrypt(inputData, key);
            dataController.writeData(targetPath, outputData);

            System.gc();
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    public void encrypt(CryptoAlgorithmService<IKeyPair, IAlgorithmController<IKeyPair>> cryptoService, PublicKey publicKey) {
        try {
            String sourcePath = pathController.getFirstPath();
            String targetPath = pathController.getSecondPath();

            Data inputData = dataController.readData(sourcePath);
            Data outputData = cryptoService.encryptWithPublicKey(inputData, publicKey);
            dataController.writeData(targetPath, outputData);

            System.gc();
        } catch (Exception e) {
            throw new RuntimeException("Asymmetric encryption failed", e);
        }
    }

    // Методы для дешифрования
    public void decrypt(CryptoAlgorithmService<IKeySingle, IAlgorithmController<IKeySingle>> cryptoService, IKeySingle key) {
        try {
            String sourcePath = pathController.getFirstPath();
            String targetPath = pathController.getSecondPath();

            Data inputData = dataController.readData(sourcePath);
            Data outputData = cryptoService.processDecrypt(inputData, key);
            dataController.writeData(targetPath, outputData);

            System.gc();
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }

    public void decrypt(CryptoAlgorithmService<IKeyPair, IAlgorithmController<IKeyPair>> cryptoService, PrivateKey privateKey) {
        try {
            String sourcePath = pathController.getFirstPath();
            String targetPath = pathController.getSecondPath();

            Data inputData = dataController.readData(sourcePath);
            Data outputData = cryptoService.decryptWithPrivateKey(inputData, privateKey);
            dataController.writeData(targetPath, outputData);

            System.gc();
        } catch (Exception e) {
            throw new RuntimeException("Asymmetric decryption failed", e);
        }
    }
}
