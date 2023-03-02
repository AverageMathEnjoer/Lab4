package classes.alives;

import classes.city.Place;
import enums.Rank;
import enums.Status;

import java.util.Objects;
import java.util.Random;

public class Guard extends Alive{
    private static final int RANKING_RANGE = 1;
    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Guard(String name, Status status, Place place, int luck, Rank rank) {
        super(name, status, place, luck);
        this.rank = rank;
    }
    public class PromotionRequestDeniedException extends Exception {
        public PromotionRequestDeniedException(String message){
            super(message);
        }
    }
    private void raiseHisRank(Guard guard) throws PromotionRequestDeniedException{
        Rank[] table_of_ranks = Rank.values();
        if(this.rank.compareTo(guard.getRank()) > RANKING_RANGE && samePlaces(guard)){
            guard.setRank(table_of_ranks[guard.getRank().ordinal() + 1]);
            System.out.println(guard + " был повышен до " + guard.getRank());
        }
        else{
            throw new PromotionRequestDeniedException("Нет прав на повышение");
        }
    }
    public void raiseMePlease(Guard guard){
        try {
            guard.raiseHisRank(this);
        } catch (PromotionRequestDeniedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guard)) return false;
        if (!super.equals(o)) return false;
        Guard guard = (Guard) o;
        return getRank() == guard.getRank();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRank());
    }

}
