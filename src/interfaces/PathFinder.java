package interfaces;

import classes.city.City;
import math.Graph;

public interface PathFinder extends Movable{
    void findPath(City city);
}
