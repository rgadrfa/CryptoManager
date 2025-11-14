package models.file.interfaces;

import models.file.data.Data;

public interface IDataController {
    Data readData(String path);
    void writeData(String path, Data data);
}
