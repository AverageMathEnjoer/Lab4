package classes.city;

import enums.*;

import java.util.Arrays;
import java.util.Objects;

public class Room extends Place{
    private static final double STANDART_VOLUME = 144;
    private double volume;
    private Furniture[] furnitures;
    private Color color;
    public Room(String name, Status status, Furniture[] furnitures, String desciption, double volume, Color color){
        super(name, status, desciption);
        this.color = color;
        this.volume = volume;
        this.furnitures = furnitures;
    }
    public Room(String name, Furniture[] furnitures, String desciption, double volume){
        this(name, Status.NONE, furnitures, desciption, volume, Color.NONE);
    }
    public Room(String name){
        super(name);
        volume = STANDART_VOLUME;
        color = Color.NONE;
    }

    public Furniture[] getFurnitures() {
        if (furnitures == null){
            return null;
        }
        return furnitures.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return Double.compare(room.volume, volume) == 0 && Arrays.equals(getFurnitures(), room.getFurnitures()) && color == room.color;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), volume, color);
        result = 31 * result + Arrays.hashCode(getFurnitures());
        return result;
    }
}
