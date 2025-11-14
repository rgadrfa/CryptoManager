package models.file.controllers;

import models.file.interfaces.IFilePathController;

public class FilePathController implements IFilePathController {
    private String firstPath;
    private String secondPath;

    @Override
    public void setFirstPath(String path) {
        this.firstPath = path;
    }

    @Override
    public void setSecondPath(String path) {
        this.secondPath = path;
    }

    @Override
    public String getFirstPath() {
        return firstPath;
    }

    @Override
    public String getSecondPath() {
        return secondPath;
    }
}