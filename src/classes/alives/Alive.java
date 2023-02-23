package classes.alives;

import classes.city.Place;
import classes.exceptions.VertexNotInGraphException;
import enums.Status;
import interfaces.*;
import classes.Statused;
import Math.Graph;

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
    public void moveIt(Graph<Place> graph, Place place, Transportable obj) {

    }

    @Override
    public Place getPlace() {
        return place;
    }
}
