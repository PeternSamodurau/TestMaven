package lesson_19_IO_and_NIO.Skillbox.Parsing_JSON_GSON_19_10.Restaurant_with_List;

import java.util.List;

public class Restaurant {
    private String name;
    private List<RestaurantMenuItem> items;

    public Restaurant(String name, List<RestaurantMenuItem> items) {
        this.name = name;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
