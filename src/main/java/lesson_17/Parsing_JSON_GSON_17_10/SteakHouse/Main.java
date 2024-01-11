package lesson_17.Parsing_JSON_GSON_17_10.SteakHouse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lesson_17.Parsing_JSON_GSON_17_10.UserNested.UserAddress;
import lesson_17.Parsing_JSON_GSON_17_10.UserNested.UserNested;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        serialize();
       System.out.println(deserialize());
    }
    private static void serialize() {
       RestaurantOwner restaurantOwner = new RestaurantOwner("Peter Samod",
               new UserAddress("India","Bodalim","good","40"));
       RestaurantStaff cook = new RestaurantStaff("Ivan",25,1000);
       RestaurantStaff waiter = new RestaurantStaff("Vasia",20,500);

       Restaurant restaurant = new Restaurant("Три пескаря",restaurantOwner, cook, waiter);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();// для фрматирования json с отступами
        String s = gson.toJson(restaurant);

        File file = new File("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/SteakHouse/steakHouse.json");

        PrintWriter pw = null;              // создает файл по пути - /Users/АВС/IdeaProjects/Data/info.txt
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
            reader = new FileReader("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/SteakHouse/steakHouse.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();

        Restaurant restaurant = gson.fromJson(reader, Restaurant.class);

        return restaurant;
    }
}
