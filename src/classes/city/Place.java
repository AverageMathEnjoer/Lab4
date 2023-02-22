package classes.city;

import classes.Statused;
import enums.Status;

import java.util.Arrays;
import java.util.Objects;

public class Place extends Statused {

    protected String desciption;
    public Place(String name, Status status, String desciption){
        super(name, status);
        this.desciption = desciption;
    }
    public Place(String name){
        this(name, "Никто это не описывал");
    }
    public Place(String name, String desciption){
        super(name, Status.NONE);
        this.desciption = desciption;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return Objects.equals(getDesciption(), place.getDesciption());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDesciption());
    }

    @Override
    public String toString() {
        return "{" + getName() + "}";
    }
}
