package lesson_19_IO_and_NIO.Skillbox.Parsing_JSON_GSON_19_10.Restaurant_with_List;

public class RestaurantMenuItem {
   // @SerializedName(value = "fullName", alternate = "fullName1")
    private String name;
   // @SerializedName("fullPrice")
    private float price;

    public RestaurantMenuItem(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "RestaurantMenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
