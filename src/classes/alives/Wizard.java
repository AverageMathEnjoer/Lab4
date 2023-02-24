package classes.alives;

import classes.MaterialOfTheUniverseAndMagic;
import classes.Statused;
import classes.books.MagicText;
import classes.city.Place;
import enums.Status;
import math.Magic;

public class Wizard extends Student{
    public Wizard(String name, Status status, Place place, int luck, int intellect) {
        super(name, status, place, luck, intellect);
    }
    public Wizard(String name, Place place, int luck, int intellect) {
        super(name, Status.BENT, place, luck, intellect);
    }
    public void cast(MagicText spell, Statused obj){
        if(Magic.compareStats(intellect, spell.getKnowledge(), 1) == 1){
            obj.setStatus(spell.getInnerMagic());
            System.out.println(this + " наложил заклятье на " + obj);
        }
        else{
            System.out.println(this + " не смог");
        }
    }
    public void investigate(MaterialOfTheUniverseAndMagic obj){
        final int magic_number = 100;
        if(obj.getStability() + intellect > magic_number){
            intellect += Magic.randDrop(magic_number, 0.77);
            obj.decreaseStability(Magic.randDrop(magic_number, 0.13));
        }else{
            obj.distorbThoseAround(this);
        }
    }
}
