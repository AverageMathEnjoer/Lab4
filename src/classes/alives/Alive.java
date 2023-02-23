package classes.alives;

import classes.Statused;
import classes.books.Text;
import classes.city.Place;
import classes.city.Shelf;
import classes.exceptions.VertexNotInGraphException;
import enums.Status;
import interfaces.Movable;
import interfaces.Transportable;
import math.Graph;

import math.Magic;

import java.util.Objects;

public abstract class Alive extends Statused implements Movable{
    protected Place place;
    protected int luck;
    @Override
    public void moveTo(Graph<Place> graph, Place place) {
        try{
            if(graph.connected(this.getPlace(), place) != null){
                System.out.println(graph.connected(this.getPlace(), place));
                this.place = place;
            }
        } catch (VertexNotInGraphException exception) {
            System.out.printf(exception.getMessage() + " // " + exception.getVertex().toString() + "\n");
        }
    }

    public Alive(String name, Status status, Place place, int luck){
        super(name, status);
        this.place = place;
        this.luck = luck;
    }

    public Alive(String name, Place place){
        super(name, Status.NONE);
        this.place = place;

    }

    @Override
    public void moveIt(Graph<Place> graph, Place place, Transportable obj, Shelf shelf) {
        moveTo(graph, place);
        if(this.place.equals(place)){
            try {
                obj.changePlace(place, shelf);
            }
            catch (Text.RuinedLogicOfBookMigrationException e){
                System.out.printf(e.getMessage() + "\n");
            }
        }
    }

    @Override
    public Place getPlace() {
        return place;
    }

    public int getLuck() {
        return luck;
    }
    protected void takeHisLuck(Alive alive){
        luck += Magic.randDrop(alive.getLuck(), 0.13);
    }
    public void makeSound(){
        System.out.println("был издан звук");
    }

    public void snore(){
        System.out.println("хрхрхрхрххрх");
    }

    @Override
    public String toString() {
        return "Alive{" +
                "place=" + place +
                ", luck=" + luck +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alive)) return false;
        if (!super.equals(o)) return false;
        Alive alive = (Alive) o;
        return getLuck() == alive.getLuck() && Objects.equals(getPlace(), alive.getPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPlace(), getLuck());
    }
}
