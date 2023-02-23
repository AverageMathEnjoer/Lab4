package classes.books;

import classes.Statused;
import classes.city.Furniture;
import classes.city.Place;
import classes.city.Room;
import classes.city.Shelf;
import enums.Status;
import interfaces.Transportable;

public abstract class Text extends Statused implements Transportable {
    protected Shelf shelf;
    protected Place place;

    @Override
    public void changePlace(Place place, Shelf shelf) throws RuinedLogicOfBookMigrationException{
        this.shelf.decreaseCount();
        if(shelf != null){
            if(place instanceof Room){
                Room room = (Room) place;
                Furniture[] furnitures = room.getFurnitures();
                boolean flag = false;
                for(Furniture furniture: furnitures){
                    if(shelf.equals(furniture)){
                        flag = true;
                    }
                }
                if(!flag){
                    this.shelf = null;
                    this.place = place;
                    throw new RuinedLogicOfBookMigrationException("Полка с комнатой не сходится, поэтому придется обойтись без полки");
                }
            }
            else{
                this.shelf = null;
                this.place = place;
                throw new RuinedLogicOfBookMigrationException("Полка с местом не сходится, поэтому придется обойтись без полки");
            }
            shelf.increaseCount();
        }
    }

    protected int knowledge;
    public Text(String name, Status status, Shelf shelf, Place place, int knowledge) throws RuinedLogicOfBookCreationException{
        super(name, status);
        if(shelf != null){
            if(place instanceof Room){
                Room room = (Room) place;
                Furniture[] furnitures = room.getFurnitures();
                boolean flag = false;
                for(Furniture furniture: furnitures){
                    if(shelf.equals(furniture)){
                        flag = true;
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
    public class RuinedLogicOfBookCreationException extends RuntimeException {
        public RuinedLogicOfBookCreationException(String message){
            super(message);
        }
    }
    public class RuinedLogicOfBookMigrationException extends Exception {
        public RuinedLogicOfBookMigrationException(String message){
            super(message);
        }
    }
    public Text(String name, Place place){
        this(name, Status.NONE, null, place, 10);
    }

    public int getKnowledge() {
        return knowledge;
    }
}
