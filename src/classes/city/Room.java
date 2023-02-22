package classes.city;

import enums.*;

public class Room extends Place{
    final double STANDART_VOLUME = 144;
    private double volume;
    private Color color;
    public Room(String name, Status status, Furniture[] furnitures, String desciption, double volume, Color color){
        super(name, status, furnitures, desciption);
        this.color = color;
        this.volume = volume;
    }
    public Room(String name){
        super(name);
        volume = STANDART_VOLUME;
        color = Color.NONE;
    }
}
