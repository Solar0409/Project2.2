import javax.swing.*;
import java.lang.reflect.Type;

public class Ship {
    private int count;
    private Type size;
    private Size type;
    public Ship (Size size, Type type){
        this.size = size;
        this.type = type;
    }
    public  boolean countCheck(){
        if(count >=size.getValue){
            return false;
        }
        return true;
    }
    public int getCount(){
        return  count;
    }
    public Object getType(){
        return type;

    }
    public Object getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "count=" + count +
                ", size=" + size +
                ", type=" + type +
                '}';
    }

    public int add(int i) {

        return i;
    }
}
