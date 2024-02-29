public class VolatileFlag {
    private volatile boolean running = true;
    public int a = 0;
    public  void runOperation(){
        while(running){
            a++;
        }
        System.out.println("Operation finished" + a);
    }
    public  void stopOperation(){
        running = false;
    }
}
