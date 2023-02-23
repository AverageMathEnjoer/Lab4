import classes.alives.Alive;
import classes.city.City;
import classes.city.Place;

import static classes.city.City.buildCity;

public class Main {
    public static void main(String[] args) {
        City ankMorpork = buildCity();
        ankMorpork.show();
        Place[] places = ankMorpork.getPlaces();
        /* Alive chel = new Alive("Мужик", places[3]);
        System.out.println(chel.getPlace());
        chel.moveTo(ankMorpork, places[4]);
        System.out.println(chel.getPlace());
        Place a = new Place("Где-то");
        Place b = new Place("другое где-то");
        chel.moveTo(ankMorpork, a);
        System.out.println(chel.getPlace());
        Alive gigachad = new Alive("Чад", a);
        gigachad.moveTo(ankMorpork, b); */
    }
}
