package classes.books;

import classes.city.Place;
import classes.city.Shelf;
import classes.exceptions.InvalidСonfinesException;
import enums.Status;
import static math.Magic.randomStat;

public class MaterialOfCourse extends Text{
    private int information;
    public MaterialOfCourse(String name, Status status, Shelf shelf, Place place, int knowledge, int information) {
        super(name, status, shelf, place, knowledge);
        this.information = information;
    }
    public MaterialOfCourse(String name, Place place) {
        this(name, Status.NONE, null, place, randomStat(10, 20), randomStat(20, 10));
    }

    @Override
    public Place getPlace() {
        return null;
    }
}
