package interfaces;

import classes.city.*;
import math.Graph;

public interface Movable extends Placeable{
    void moveTo(Graph<Place> graph, Place place);
    void moveIt(Graph<Place> graph, Place place, Transportable obj);
}
