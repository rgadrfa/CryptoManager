package models.file.interfaces;

public interface IFileController {
    void createFile(String path);
    void deleteFile(String path);
    boolean fileExists(String path);
}
