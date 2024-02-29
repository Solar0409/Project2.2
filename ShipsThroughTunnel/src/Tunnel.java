import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Tunnel {
    // в тунеле находятся корабли - при помощи List
    private List<Ship> store;
    private static final int maxShipInTunnel = 5;
    private static final int minShipsInTunnel = 0;
    private int shipsCounter = 0;

    public Tunnel() {
        store = new ArrayList<>();
    }
// добавляем корабли в туннель
    public synchronized boolean add(Ship element) {
        try {
            if (shipsCounter < maxShipInTunnel) {
                notifyAll();//возобновляет работу всех потоков,
                // для которых ранее был вызван метод wait()
//кога срабатывает метод add(), ship<5 -  он пробуждает поток, который работает с методом get()
// И наоборот, когда срабатывает метод get(), ship>0,он пробуждает поток, работающий с методом add().
                store.add(element);
                String info = String.format("%s + The ship arrived in the tunnel: %s %s %s",
                        store.size(), element.getType(), element.getSize(),
                        Thread.currentThread().getName());
                System.out.println(info);
            } else {
                System.out.println(store.size() + "> There is no place for a ship in the tunnel: "
                        + Thread.currentThread().getName());
                wait();//чтобы остановить поток и снять mutex (семафор - поле для синхронизации потоков) вызываем метод wait()

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shipsCounter < maxShipInTunnel;
    }
    // достаем корабли из туннеля
    public synchronized Ship get(Type shipType) {
        try {
            if (shipsCounter > minShipsInTunnel) {
                notifyAll();// пробуждаем поток ( задача метода: переключить поток из состяния WAITING  в Runnable)
                for (Ship ship : store) {
                    if (ship.getType() == shipType) {
                        shipsCounter--;
                        System.out.println(store.size() + " The ship is taken from the tunnel: " + Thread.currentThread().getName());
                        store.remove(ship);
                        return ship;
                    }
                }
            }
            System.out.println(" There are no ships in the tunnel");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}





