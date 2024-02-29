import java.lang.reflect.Type;
import java.util.Random;

import static javax.swing.text.StyleConstants.Size;

//класс будет генерировать кораблики в независимом потоке
//создаем задачу для потока, реализовав интерфейс Runnable
public class ShipGenerator implements Runnable {
    private final Tunnel tunnel;
    private final int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < shipCount) {
            Thread.currentThread().setName(" Generator ship");
            count++;
            tunnel.add(new Ship(getRandomSize().getRemdomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private Object getRandomSize() {
        return null;
    }

    private Type getRemdomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRemdomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}
