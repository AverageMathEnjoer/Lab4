package classes.books;

import classes.city.Place;
import classes.city.Shelf;
import enums.Status;

import java.util.Objects;

public class MagicText extends Text{
    private final Status innerMagic;

    public MagicText(String name, Status status, Shelf shelf, Place place, int knowledge, Status magic){
        super(name, status, shelf, place, knowledge);
        this.innerMagic = magic;
    }

    public Status getInnerMagic() {
        return innerMagic;
    }

    public MagicText(String name, Place place){
        this(name, Status.NONE, null, place, 10, Status.GLOW);
    }

    @Override
    public String toString() {
        return "MagicText{" +
                "innerMagic=" + innerMagic +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MagicText)) return false;
        if (!super.equals(o)) return false;
        MagicText magicText = (MagicText) o;
        return getInnerMagic() == magicText.getInnerMagic();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInnerMagic());
    }
}
