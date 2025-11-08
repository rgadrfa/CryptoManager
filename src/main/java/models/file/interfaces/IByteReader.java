package models.file.interfaces;

import models.file.data.OutputData;

import java.io.IOException;

public interface IByteReader {
    OutputData getBytes() throws IOException;
}
