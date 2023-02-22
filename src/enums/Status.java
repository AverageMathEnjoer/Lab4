package enums;

public enum Status {
    INFIRE("в огне", 5),INDARK("окутан мраком", 3),
    GLOW("светится", 2), IN_LIGHT_DARKNESS("свет не столько разгонял, сколько подчеркивал мрак", 5),
    SLEEP("спит", 1), NONE("ничего не происходит", 1),
    NONEXISTENENT("не существует", 100);

    final private String description;
    final private int level;
    Status(String description, int level) {
        this.description =description;
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Status{" +
                "description='" + description + '\'' +
                ", level=" + level +
                "} ";
    }
}
