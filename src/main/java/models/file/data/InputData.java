package models.file.data;

public class InputData {
    public final byte[] inputData;
    public InputData(byte[] outputData) {
        this.inputData = outputData;
    }

    public byte[] getInputData(){
        return inputData;
    }
}
