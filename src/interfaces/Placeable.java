package interfaces;

import classes.city.Place;

public interface Placeable {
    Place getPlace();
    default boolean samePlaces(Placeable p){
        return p.getPlace().equals(this.getPlace());
    }
}
