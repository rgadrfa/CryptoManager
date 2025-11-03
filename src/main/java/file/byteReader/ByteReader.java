package file.byteReader;

import crypto.data.OutputData;
import file.interfaces.IByteReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ByteReader implements IByteReader {

    private final String path;

    public ByteReader(String path) {
        this.path = path;
    }

    @Override
    public OutputData getBytes() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return new OutputData(bytes);
    }
}
