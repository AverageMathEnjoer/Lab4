package classes;

import enums.Status;

public class MaterialOfTheUniverseAndMagic extends Statused{
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

    public void distorbThoseAround(Statused obj){
        Status[] statuses = Status.values();
        for(int i = statuses.length - 1; i >= 0; i--){
            if((getHazard() / 10) * ((101 - statuses[i].getLevel()) / 100) < 1 && !likeIt()){
                obj.setStatus(statuses[i]);
                stability=0;
                System.out.println("Статус изменен на" + obj.getStatus());
                break;
            }
        }
    }
    public MaterialOfTheUniverseAndMagic(String name, Status status, double stability, int hazard) {
        super(name, status);
        this.hazard = hazard;
        this.stability = stability;
    }
}
