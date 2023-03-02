package classes.books;

import classes.Statused;
import classes.city.Furniture;
import classes.city.Place;
import classes.city.Room;
import classes.city.Shelf;
import enums.Status;
import interfaces.Transportable;

import java.util.Objects;

public abstract class Text extends Statused implements Transportable {
    protected Shelf shelf;
    protected Place place;

    @Override
    public void changePlace(Place place, Shelf shelf) throws RuinedLogicOfBookMigrationException{
        this.shelf.decreaseCount();
        this.place = place;
        if(shelf != null){
            if(place instanceof Room){
                Room room = (Room) place;
                Furniture[] furnitures = room.getFurnitures();
                if(furnitures == null){
                    this.shelf = null;
                    throw new RuinedLogicOfBookMigrationException("Полка с комнатой не сходится, поэтому придется обойтись без полки");
                }
                boolean flag = false;
                for(Furniture furniture: furnitures){
                    if(shelf.equals(furniture)){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    this.shelf = null;
                    throw new RuinedLogicOfBookMigrationException("Полка с комнатой не сходится, поэтому придется обойтись без полки");
                }
            }
            else{
                this.shelf = null;
                throw new RuinedLogicOfBookMigrationException("Полка с местом не сходится, поэтому придется обойтись без полки");
            }
            shelf.increaseCount();
            this.shelf = shelf;
        }
    }

    protected int knowledge;
    public Text(String name, Status status, Shelf shelf, Place place, int knowledge){
        super(name, status);
        class RuinedLogicOfBookCreationException extends RuntimeException {
            public RuinedLogicOfBookCreationException(String message){
                super(message);
            }
        }
        if(shelf != null){
            if(place instanceof Room){
                Room room = (Room) place;
                Furniture[] furnitures = room.getFurnitures();
                if(furnitures == null){
                    throw new RuinedLogicOfBookCreationException("Полка с комнатой не сходится");
                }
                boolean flag = false;
                for(Furniture furniture: furnitures){
                    if (shelf.equals(furniture)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    throw new RuinedLogicOfBookCreationException("Полка с комнатой не сходится");
                }
            }
            else throw new RuinedLogicOfBookCreationException("Полка с местом не сходится");
            shelf.increaseCount();
        }
        this.shelf = shelf;
        this.place = place;
        this.knowledge = knowledge;
    }

    public class RuinedLogicOfBookMigrationException extends Exception {
        public RuinedLogicOfBookMigrationException(String message){
            super(message);
        }
    }
    public Text(String name, Place place){
        this(name, Status.NONE, null, place, 10);
    }

    @Override
    public Place getPlace() {
        return place;
    }

    public int getKnowledge() {
        return knowledge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;
        if (!super.equals(o)) return false;
        Text text = (Text) o;
        return getKnowledge() == text.getKnowledge() && Objects.equals(shelf, text.shelf) && getPlace().equals(text.getPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shelf, getPlace(), getKnowledge());
    }

    @Override
    public String toString() {
        return "Text{" +
                "shelf=" + shelf +
                ", place=" + place +
                ", knowledge=" + knowledge +
                "} " + super.toString();
    }
}
