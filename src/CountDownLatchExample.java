import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 3;
        CountDownLatch startSignal = new CountDownLatch(1);
        Runnable task = () -> {
            try {
                startSignal.await();
                System.out.println("Thread " + Thread.currentThread().getId() + " is running");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

            }

        };
        for ( int i = 0; i< numberOfThreads; i++){
            new Thread(task).start();
        }
        System.out.println("Threads are ready");
        startSignal.countDown();
    }
}
