package classes.city;

import classes.Statused;
import enums.Status;

import java.util.Arrays;
import java.util.Objects;

public class Place extends Statused {
    protected Furniture[] furnitures;
    protected String desciption;
    public Place(String name, Status status, Furniture[] furnitures, String desciption){
        super(name, status);
        this.furnitures = furnitures;
        this.desciption = desciption;
    }
    public Place(String name){
        super(name, Status.NONE);
        this.desciption = "Никто это еще не описал";
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
        return Arrays.equals(furnitures, place.furnitures) && Objects.equals(getDesciption(), place.getDesciption());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getDesciption());
        result = 17 * result + Arrays.hashCode(furnitures);
        return result;
    }
}
