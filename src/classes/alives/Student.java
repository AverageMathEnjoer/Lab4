package classes.alives;

import classes.books.MaterialOfCourse;
import classes.city.Furniture;
import classes.city.Place;
import enums.Status;
import math.Magic;

import java.util.Objects;

public class Student extends Alive{
    protected int intellect;
    public Student(String name, Status status, Place place, int luck, int intellect) {
        super(name, status, place, luck);
        this.intellect = intellect;
    }
    public Student(String name, Place place){
        this(name, Status.NONE, place, 10, 1);
    }
    public void Study(MaterialOfCourse book){
        if(samePlaces(book)){
            if(Magic.compareStats(intellect, book.getKnowledge(), 1) == 1){
                intellect += Magic.randDrop(book.getInformation(), 0.77);
            }else{
                System.out.println("Студент " + name + " со слезами на глазах захлопнул книгу, не в силах понять ее");
            }
        }
    }
    private void say(String message){
        System.out.println(message);
    }
    public void markIt(Furniture furniture){
        furniture.setMarked(true);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return intellect == student.intellect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), intellect);
    }
}
