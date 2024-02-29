import java.lang.reflect.Type;

public enum ShipAttribute implements java.lang.reflect.Type {
    Type,Size,DRESS,BANANA,MEAL;


    @Override
    public String getTypeName() {
        return Type.super.getTypeName();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static <T extends Enum<T>> T valueOf(Class<T> enumClass, String name) {
        return Enum.valueOf(enumClass, name);
    }
}

