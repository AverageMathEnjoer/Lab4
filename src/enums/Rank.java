package enums;

public enum Rank {
    CONSTABLE("Констебль"), CORPORAL("Капрал"), SERGEANT("Сержант"), CAPTAIN("Капитан"), COMMNDER("Командор");
    private final String name;
    Rank(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
