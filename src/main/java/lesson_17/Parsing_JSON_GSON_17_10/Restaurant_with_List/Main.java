package lesson_17.Parsing_JSON_GSON_17_10.Restaurant_with_List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        serialize();
       System.out.println(deserialize());
    }
    private static void serialize() {
        List<RestaurantMenuItem> restaurantMenuItemList = new ArrayList<>();
        restaurantMenuItemList.add(0,new RestaurantMenuItem("steak",10));
        restaurantMenuItemList.add(1,new RestaurantMenuItem("soup",5));
        restaurantMenuItemList.add(2, new RestaurantMenuItem("beer",1));

        Restaurant restaurant = new Restaurant("Три пескаря", restaurantMenuItemList);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();// для фрматирования json с отступами
        String s = gson.toJson(restaurant);

        File file = new File("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/Restaurant_with_List/restaurant.json");

        PrintWriter pw = null;              // создает файл по пути
        try {
            pw = new PrintWriter(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.println(s);                          // пишем в файл
        pw.flush();
        pw.close();

    }
    private static Object deserialize() {

        FileReader reader = null;
        try {
            reader = new FileReader("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/Restaurant_with_List/restaurant.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();

        Restaurant restaurant = gson.fromJson(reader,Restaurant.class);

        return restaurant;
    }
}
