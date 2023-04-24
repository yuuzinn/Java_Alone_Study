package JavaOfGod.version2.ch27;

import java.nio.IntBuffer;

public class NioDetailSample {
    public static void main(String[] args) {
        NioDetailSample test = new NioDetailSample();
//        test.checkBuffer();
        test.checkBufferStatus();
    }

    public void checkBuffer() {
        try {
            IntBuffer buffer = IntBuffer.allocate(1024);
            for (int i = 0; i < 100; i++) {
                buffer.put(i);
            }
            System.out.println("Buffer capacity is " + buffer.capacity());
            System.out.println("Buffer limit is " + buffer.limit());
            System.out.println("Buffer position is " + buffer.position());
            buffer.flip();
            System.out.println("Buffer flips !!!");
            System.out.println("Buffer limit is " + buffer.limit());
            System.out.println("Buffer position is " + buffer.position());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printBufferStatus(String job, IntBuffer buffer) {
        System.out.println("Buffer " + job + " ! ! !");
        System.out.printf("Buffer position = %d remaining =%d limit = %d\n",
                buffer.position(), buffer.remaining(), buffer.limit());
    }
    public void checkBufferStatus() {
        try {
            IntBuffer buffer = IntBuffer.allocate(1024);
            buffer.get();
            printBufferStatus("get", buffer);
            buffer.mark();
            printBufferStatus("mark", buffer);
            buffer.get();
            printBufferStatus("get", buffer);
            buffer.reset();
            printBufferStatus("reset", buffer);
            buffer.rewind();
            printBufferStatus("rewind", buffer);
            buffer.clear();
            printBufferStatus("clear", buffer);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
