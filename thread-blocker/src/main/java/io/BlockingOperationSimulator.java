package io;

public class BlockingOperationSimulator {

    public int blockFor(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
        return milliseconds;
    }
}
