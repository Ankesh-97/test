package design_patterns.decorator_pattern.practiceQuestion.inputstream;

public class BufferInputStreamDecorator extends MyInputStreamDecorator {

    private static final int BUFFER_SIZE = 8;
    private byte[] buffer = new byte[BUFFER_SIZE];
    private int pos = 0;
    private int count = 0;

    protected BufferInputStreamDecorator(MyInputStream myInputStream) {
        super(myInputStream);
    }

    @Override
    public int read() {
        if (pos >= count) {
            count = 0;
            pos = 0;
            int data;
            while (count < BUFFER_SIZE && (data = super.getMyInputStream().read()) != -1) {
                buffer[count++] = (byte) data;
            }
            if (count == 0) return -1;
        }
        return buffer[pos++] & 0xFF;
    }
}
