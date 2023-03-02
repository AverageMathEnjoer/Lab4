package classes.alives;

import classes.city.Place;
import enums.Status;
import math.Magic;

import java.util.Objects;

public class StrangeCreature extends Alive{
    public StrangeCreature(String name, Status status, Place place, int luck) {
        super(name, status, place, luck);
    }
    public StrangeCreature(String name, Place place){
        this(name, Status.NONE, place, 10);
    }
    public void yell(){
        System.out.println("оаоаоаооаоа");
    }
    public void attack(Alive target){
        int battle_result = Magic.compareStats(this.luck, target.getLuck(), 7);
        if(!this.samePlaces(target)){
            System.out.println("Цель где-то далеко");
        }
        else {
            if (battle_result == 1) {
                this.takeHisLuck(target);
                target.setStatus(Status.NONEXISTENENT);
            }
            if (battle_result == -1) {
                target.takeHisLuck(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StrangeCreature)) return false;
        return super.equals(o);
    }
}
