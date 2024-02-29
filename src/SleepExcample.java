import java.time.LocalTime;

public class SleepExcample implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(1000);
//                System.out.println("Счетчик" + i+ "t=>" +  System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime-startTime;
            System.out.println("Cчетчик" + i + " Time of duration" + duration +  " MC");

        }
    }
}
