package lesson_19.Parsing_JSON_GSON_19_10.SteakHouse;

public class Restaurant {
    private String name;
    private RestaurantOwner owner;
    private RestaurantStaff cook;
    private RestaurantStaff waiter;

    public Restaurant(String name, RestaurantOwner owner, RestaurantStaff cook, RestaurantStaff waiter) {
        this.name = name;
        this.owner = owner;
        this.cook = cook;
        this.waiter = waiter;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                ", cook=" + cook +
                ", waiter=" + waiter +
                '}';
    }
}
