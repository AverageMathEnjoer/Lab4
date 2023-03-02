package classes;

import enums.Status;

import java.util.Objects;

public class MaterialOfTheUniverseAndMagic extends Statused{
    private static final double STABLE_STATE = 100;
    private double stability;
    private int hazard;

    public double getStability() {
        return stability;
    }

    public int getHazard() {
        return hazard;
    }

    boolean likeIt(){
        return !(Math.random() < 0.987);
    }
    public void decreaseStability(double number){
        stability -= number;
    }

    public void distorbThoseAround(Statused obj){
        Status[] statuses = Status.values();
        for(int i = statuses.length - 1; i >= 0; i--){
            if((getHazard() / 10) * ((101 - statuses[i].getLevel()) / 100) < 1 && !likeIt()){
                obj.setStatus(statuses[i]);
                stability = STABLE_STATE;
                System.out.println("Потоками таинственной энергии статус " + obj + " изменен на " + obj.getStatus());
                break;
            }
        }
    }
    public MaterialOfTheUniverseAndMagic(String name, Status status, double stability, int hazard) {
        super(name, status);
        this.hazard = hazard;
        this.stability = stability;
    }

    @Override
    public String toString() {
        return "MaterialOfTheUniverseAndMagic{" +
                "stability=" + stability +
                ", hazard=" + hazard +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaterialOfTheUniverseAndMagic)) return false;
        if (!super.equals(o)) return false;
        MaterialOfTheUniverseAndMagic that = (MaterialOfTheUniverseAndMagic) o;
        return Double.compare(that.getStability(), getStability()) == 0 && getHazard() == that.getHazard();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStability(), getHazard());
    }
}
