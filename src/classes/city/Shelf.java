package classes.city;

import enums.Color;
import enums.Status;

public class Shelf extends Furniture{
    int capacity;
    int count_of_books;

    Shelf(String name, Status status, Color color, int capacity){
        super(name, status, color);
        this.capacity = capacity;
    }
    Shelf(String name, int capacity){
        super(name);
        this.capacity = capacity;
    }

    public int getCount() {
        return count_of_books;
    }

    public int getCapacity() {
        return capacity;
    }
}
