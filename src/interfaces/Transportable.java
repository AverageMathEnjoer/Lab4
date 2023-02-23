package interfaces;

import classes.city.Place;

public interface Transportable extends Placeable{
    void changePlace(Place place);
}
