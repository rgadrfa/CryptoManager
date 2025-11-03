package file.interfaces;

import crypto.data.OutputData;

import java.io.IOException;

public interface IByteReader {
    OutputData getBytes() throws IOException;
}
