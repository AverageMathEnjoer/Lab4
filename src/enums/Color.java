package enums;

public enum Color {
    BLUE("Синий"), NONE("Обычный"), OCTARINE("Октариновый");
    final private String title;
    Color(String name){
        title = name;
    }

    public String getTitle() {
        return title;
    }
}
