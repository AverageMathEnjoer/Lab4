package classes.city;

import enums.Color;
import enums.Status;
import static math.Magic.chanceMath;

public class Shelf extends Furniture{
    int capacity = 0;
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

    public void bend(){
        if(chanceMath(0.17, getCount(), getCapacity())){
            setStatus(Status.BENT);
            System.out.println("Полка гнется");
        }
    }
}
