package models.file.controllers;

import models.file.interfaces.IFileController;
import java.io.File;
import java.io.IOException;

public class FileController implements IFileController {

    public FileController() {
    }

    @Override
    public void createFile(String path) {
        try {
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File created: " + path);
            } else {
                System.out.println("File already exists: " + path);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create file: " + path, e);
        }
    }

    @Override
    public void deleteFile(String path) {
        File file = new File(path);
        if (file.delete()) {
            System.out.println("File deleted: " + path);
        } else {
            throw new RuntimeException("Failed to delete file: " + path);
        }
    }

    @Override
    public boolean fileExists(String path) {
        return new File(path).exists();
    }
}