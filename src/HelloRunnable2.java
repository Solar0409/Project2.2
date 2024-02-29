public class HelloRunnable2 implements Runnable {
    public void run() {
        System.out.println("Привет от потока 2" + Thread.currentThread().getName());
    }

}