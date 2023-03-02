import classes.alives.*;
import classes.books.*;
import classes.city.*;
import enums.*;
import interfaces.*;
import math.*;

import static classes.city.City.buildCity;

public class Main {
    public static void main(String[] args) {
        City ankMorpork = buildCity();
        ankMorpork.show();
        Place[] places = ankMorpork.getPlaces();
        Orangutan librarian = new Orangutan("Книженосец",Status.NONE, places[2], 10);
        librarian.findPath(ankMorpork);
        System.out.println(librarian.getPlace());
        PathFinder vagabond = new PathFinder() {
            private final String name = "Бродяга";
            Place place = places[7];
            double stamina = 100.0d;
            @Override
            public void findPath(City city) {
                Place[] places = city.getPlaces();
                while(stamina > 10.0d){
                    int num = (int) (places.length * Math.random());
                    moveTo(city, places[num]);
                    stamina -= Magic.randDrop(100.0d, 0.77);
                }
                System.out.println(name + " устал. Остановился в " + this.place);
            }

            @Override
            public void moveTo(Graph<Place> graph, Place place) {
                if(graph.inGraph(place)){
                    this.place = place;
                    System.out.println(name + " наплевал на границы города. И ушел в " + this.place);
                }else{
                    System.out.println(name + " не путешествует вне города");
                }
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
        };
        vagabond.findPath(ankMorpork);
        Guard guard1 = new Guard("Морковка", Status.NONE, places[11], 10, Rank.CONSTABLE);
        Guard guard2 = new Guard("Ваймс", Status.NONE, places[11], 10, Rank.CAPTAIN);
        guard2.raiseMePlease(guard1);
        guard1.raiseMePlease(guard2);
        MaterialOfCourse book = new MaterialOfCourse("Книжка", Status.NONE,((Shelf)((Room) places[3]).getFurnitures()[0]), places[3], 10, 10);
        System.out.println(book.getPlace());
        MagicText spell = new MagicText("Спелл", Status.NONE, ((Shelf)((Room) places[3]).getFurnitures()[0]), places[4], 10, Status.GLOW);
    }
}
