package classes.city;

import enums.Color;
import enums.Status;

import java.util.Objects;

import static math.Magic.chanceMath;

public class Shelf extends Furniture{
    private int capacity = 0;
    private int count_of_books;

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
    public void increaseCount(){
        count_of_books++;
    }
    public void decreaseCount(){
        count_of_books--;
    }

    public void bend(){
        if(chanceMath(0.17, getCount(), getCapacity())){
            setStatus(Status.BENT);
            System.out.println("Полка гнется");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shelf)) return false;
        if (!super.equals(o)) return false;
        Shelf shelf = (Shelf) o;
        return getCapacity() == shelf.getCapacity() && count_of_books == shelf.count_of_books;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCapacity(), count_of_books);
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "capacity=" + capacity +
                ", count_of_books=" + count_of_books +
                "} " + super.toString();
    }
}
