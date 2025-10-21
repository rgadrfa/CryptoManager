package crypto.data;

public class OutputData {
    private final byte[] outputData;
    public OutputData(byte[] outputData) {
        this.outputData = outputData;
    }

    public byte[] getOutputData(){
        return outputData;
    }
}
