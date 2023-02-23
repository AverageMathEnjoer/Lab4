package math;

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
}
