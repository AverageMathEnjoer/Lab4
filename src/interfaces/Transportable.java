package interfaces;

import classes.books.Text;
import classes.city.Place;
import classes.city.Shelf;

public interface Transportable extends Placeable{
    void changePlace(Place place, Shelf shelf) throws Text.RuinedLogicOfBookMigrationException;
}
