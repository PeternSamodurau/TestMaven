package lesson_17.Parsing_JSON_GSON_17_10.Restaurant_with_List;

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
