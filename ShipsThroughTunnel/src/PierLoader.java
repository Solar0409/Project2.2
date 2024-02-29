import java.lang.reflect.Type;

//создадим класс - причал, где будем загружать корабли товарами.
public class PierLoader implements Runnable {
    private final Tunnel tunnel;
    private final Type shipType;

    public PierLoader(Tunnel tunnel, Type shipType) {
        this.tunnel = tunnel;
        this.shipType = shipType;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Loader" + shipType);

                //time to load the goods
                Thread.sleep(500);//нужно время для загрузки товарами и корабли должны приплыть

// как известно, метод sleep() не освобождает ресурс,
// а держит OS JVM даже во время сна, ежели метод wait(),
// который сообщает потоку, чтобы он прекратил работу и отпустил блокировку
                Ship ship = tunnel.get(shipType);
                if (ship != null)
                    while (ship.countCheck()) {
                        Thread.sleep(100);

                        System.out.println(ship.getCount() + " Loaded ship. " + ship.add(10));
                        Thread.currentThread().getName());
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
