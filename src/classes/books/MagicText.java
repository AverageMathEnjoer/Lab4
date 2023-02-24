package classes.books;

import classes.city.Place;
import classes.city.Shelf;
import enums.Status;

public class MagicText extends Text{
    private Status innerMagic;

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
}
