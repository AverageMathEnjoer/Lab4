package math;

import classes.exceptions.InvalidСonfinesException;

public class Magic {
    public static int randDrop(int num, double chance){
        return (int) (num * Math.random() * chance);
    }
    public static double randDrop(double num, double chance){
        return (num * Math.random() * chance);
    }
    public static boolean chanceMath(double chance, int current, int needed){
        return (Math.random() < (current * chance)/needed);
    }

    public static int randomStat(int min, int max) throws InvalidСonfinesException {
        if(max > min){
            return (int) ((max - min) * Math.random() + min);
        }
        else throw new InvalidСonfinesException("Вы максимум и минимум спутали", min, max);
    }
}
