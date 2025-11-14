package models.file.controllers;

import models.file.data.Data;
import models.file.interfaces.IDataController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DataController implements IDataController {

    @Override
    public Data readData(String path) {
        try {
            Path filePath = Paths.get(path);
            byte[] fileData = Files.readAllBytes(filePath);
            return new Data(fileData);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + path, e);
        }
    }

    @Override
    public void writeData(String path, Data data) {
        try {
            Path filePath = Paths.get(path);
            Files.write(filePath, data.getData(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + path, e);
        }
    }
}