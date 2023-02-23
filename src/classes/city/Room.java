package classes.city;

import enums.*;

public class Room extends Place{
    final double STANDART_VOLUME = 144;
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
        return furnitures.clone();
    }
}
