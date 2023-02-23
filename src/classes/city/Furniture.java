package classes.city;

import classes.Statused;
import enums.Color;
import enums.Status;

import java.util.Objects;

public class Furniture extends Statused {
    Furniture(String name, Status status, Color color){
        super(name, status);
        this.color = color;
    }
    Furniture(String name){
        super(name, Status.NONE);
        this.color = Color.NONE;
    }
    protected Color color;
    protected boolean marked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Furniture)) return false;
        if (!super.equals(o)) return false;
        Furniture furniture = (Furniture) o;
        return marked == furniture.marked && color == furniture.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, marked);
    }
}
