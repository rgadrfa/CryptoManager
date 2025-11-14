package models.file.data;

import lombok.Getter;

@Getter
public class Data {
    public final byte[] data;
    public Data(byte[] outputData) {
        this.data = outputData;
    }

    public byte[] getInputData(){
        return data;
    }
}
