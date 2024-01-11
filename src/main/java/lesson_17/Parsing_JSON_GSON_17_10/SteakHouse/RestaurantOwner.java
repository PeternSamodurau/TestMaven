package lesson_17.Parsing_JSON_GSON_17_10.SteakHouse;

import lesson_17.Parsing_JSON_GSON_17_10.UserNested.UserAddress;

public class RestaurantOwner {
    private String name;
    private UserAddress userAddress;

    public RestaurantOwner(String name, UserAddress userAddress) {
        this.name = name;
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "RestaurantOwner{" +
                "name='" + name + '\'' +
                ", userAddress=" + userAddress +
                '}';
    }
}
