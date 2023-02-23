package classes.city;

import Math.*;
import enums.*;

public final class City extends Graph<Place> {
    String title;
    private City(Place[] vertices, Graph.Edge<Place>[] edges, String title) {
        super(vertices, edges);
        this.title = title;
    }
    public static City buildCity(){
        Place[] places = {new Place("Никогде", "Таинйственное место, откуда никто не выбирался"),
                new Place("Библиотечный лабиринт", "Библиотечные ряды простирались отсюда и в вечность"),
                new Room("Комната библиотекаря", new Furniture[]{new Furniture("Стол Библиотекаря")} ,"Место " +
                        "где спит обезьяна", 40),
                new Room("Библиотека", new Furniture[]{new Shelf("Просто полка", 2), new Shelf("Таинственная " +
                        "полка", 3)}, "Библиотека " +
                        "представляет собой величайшее во всей множественной вселенной собрание текстов", 900000),
                new Room("Главный зал Университета"),
                new Room("Комната для коммисии", null, "Место для унижения и пытки", 120),
                new Room("Ректорат"),
                new Place("Парк"),
                new Place("Главная площадь"),
                new Place("Дворец Патриция"),
                new Place("Бесконечная улица"),
                new Place("Вход в здание ночной стражи"),
                new Room("Камеры"),
                new Room("Кабинет капитана", new Furniture[]{new Shelf("Полка, которая не хочет" +
                        " жить", 1)}, "ПОл этой комнаты был крайне липким от количества алкоголя когда-лиюо здесь" +
                        " распитого, а посреди комнаты лежало тело. Это был капитан Ваймс", 190)
        };
        Graph.Edge<Place>[] b_edges = new Edge[]{
                new Edge<>(places[1], places[0]),
                new Edge<>(places[1], places[2]),
                new Edge<>(places[2], places[1]),
                new Edge<>(places[1], places[3]),
                new Edge<>(places[3], places[1]),
                new Edge<>(places[3], places[2]),
                new Edge<>(places[2], places[3]),
                new Edge<>(places[3], places[4]),
                new Edge<>(places[4], places[3]),
                new Edge<>(places[4], places[6]),
                new Edge<>(places[6], places[4]),
                new Edge<>(places[4], places[7]),
                new Edge<>(places[7], places[4]),
                new Edge<>(places[4], places[5]),
                new Edge<>(places[7], places[8]),
                new Edge<>(places[8], places[7]),
                new Edge<>(places[9], places[8]),
                new Edge<>(places[8], places[10]),
                new Edge<>(places[8], places[11]),
                new Edge<>(places[11], places[8]),
                new Edge<>(places[11], places[13]),
                new Edge<>(places[13], places[11]),
                new Edge<>(places[11], places[12]),
                new Edge<>(places[12], places[11]),
        };
        return new City(places, b_edges, "Анк-Морпорк");
    }
    public Place[] getPlaces(){
        return vertices.clone();
    }
}
