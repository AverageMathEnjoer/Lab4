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

    public static int compareStats(int stat_1, int stat_2, double delta){
        if(((1 - Math.random() * 0.1) * stat_1) - ((1 - Math.random() * 0.1) * stat_2) > delta){
            return 1;//first win
        }
        else if(((1 - Math.random() * 0.1) * stat_2) - ((1 - Math.random() * 0.1) * stat_1) > delta){
            return -1;// second win
        }
        else return 0;//draw
    }
}
