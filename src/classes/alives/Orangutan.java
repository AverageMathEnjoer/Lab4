package classes.alives;

import classes.city.City;
import classes.city.Place;
import classes.exceptions.VertexNotInGraphException;
import enums.Status;
import interfaces.PathFinder;
import math.Graph;
import math.Graph.Edge;

public class Orangutan extends StrangeCreature implements PathFinder {
    public Orangutan(String name, Status status, Place place, int luck) {
        super(name, status, place, luck);
    }

    @Override
    public void findPath(City city) {
        while(place.getName().contains("иблио") && findNextEdge(city, this.place)){}
        System.out.println("Библиотекарь потерялся");
    }
    private boolean findNextEdge(City city, Place place){
        Place[] places = city.getPlaces();
        Place[] variants = new Place[places.length];
        int count = 0;
        for(Place placeIt: places){
            try {
                if(city.connected(place, placeIt) != null){
                    variants[count] = placeIt;
                    count++;
                }
            }catch (VertexNotInGraphException exception){
                System.out.printf(exception.getMessage() + " // " + exception.getVertex().toString() + "\n");
            }
        }
        if(count == 0){
            return false;
        }
        int num = (int)( Math.random() * count);
        this.moveTo(city, variants[num]);
        return true;
    }
}
