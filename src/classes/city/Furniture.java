package classes.city;

import classes.Statused;
import enums.Color;
import enums.Status;

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
}
