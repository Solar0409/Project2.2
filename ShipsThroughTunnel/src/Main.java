import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Avaliable number of cores: " + Runtime.getRuntime().availableProcessors());//возвращает нам количество доступных нам потоков в формате int
        Tunnel tunnel = new Tunnel();
        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 10);
        PierLoader pierLoader1 = new PierLoader(tunnel, ShipAttribute.DRESS);
        PierLoader pierLoader2 = new PierLoader(tunnel, ShipAttribute.BANANA);
        PierLoader pierLoader3 = new PierLoader(tunnel, ShipAttribute.MEAL);
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(shipGenerator);
        service.execute( pierLoader1);
        service.execute( pierLoader2);
        service.execute(pierLoader3);
        service.shutdown();
        {

        }
    }
}

