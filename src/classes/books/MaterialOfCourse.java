package classes.books;

import classes.city.Place;
import classes.city.Shelf;
import classes.exceptions.InvalidConfinesException;
import enums.Status;

import java.util.Objects;

import static math.Magic.randomStat;

public class MaterialOfCourse extends Text{
    private final int information;
    public MaterialOfCourse(String name, Status status, Shelf shelf, Place place, int knowledge, int information) {
        super(name, status, shelf, place, knowledge);
        this.information = information;
    }
    public MaterialOfCourse(String name, Place place) {
        this(name, Status.NONE, null, place, randomStat(10, 20), randomStat(20, 10));
    }

    public int getInformation() {
        return information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaterialOfCourse)) return false;
        if (!super.equals(o)) return false;
        MaterialOfCourse that = (MaterialOfCourse) o;
        return getInformation() == that.getInformation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInformation());
    }

    @Override
    public String toString() {
        return "MaterialOfCourse{" +
                "information=" + information +
                "} " + super.toString();
    }
}
