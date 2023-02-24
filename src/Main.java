import classes.alives.Alive;
import classes.alives.Orangutan;
import classes.books.MagicText;
import classes.books.MaterialOfCourse;
import classes.city.City;
import classes.city.Place;
import classes.city.Room;
import classes.city.Shelf;
import enums.Status;

import static classes.city.City.buildCity;

public class Main {
    public static void main(String[] args) {
        City ankMorpork = buildCity();
        ankMorpork.show();
        Place[] places = ankMorpork.getPlaces();
        Orangutan librarian = new Orangutan("Книженосец",Status.NONE, places[2], 10);
        librarian.findPath(ankMorpork);
        System.out.println(librarian.getPlace());
        MaterialOfCourse book = new MaterialOfCourse("Книжка", Status.NONE,((Shelf)((Room) places[3]).getFurnitures()[0]), places[3], 10, 10);
        System.out.println(book.getPlace());
        MagicText spell = new MagicText("Спелл", Status.NONE, ((Shelf)((Room) places[3]).getFurnitures()[0]), places[4], 10, Status.GLOW);
    }
}
