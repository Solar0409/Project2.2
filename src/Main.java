public class Main {
    public static void main(String[] args) throws InterruptedException{
//        Thread thread = new Thread(new HelloRunnable());
//        Thread thread1 = new Thread(new HelloRunnable2());
//        thread.start();
//        thread1.start();
//        Thread thread3 = new Thread(new SleepExcample());
//        thread3.start();
//
        VolatileFlag example = new VolatileFlag();
        Thread operationThread = new Thread((example::runOperation));
        operationThread.start();
        Thread.sleep((2000));
        example.stopOperation();
        operationThread.join();
    }
}