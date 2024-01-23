package lesson_19.Parsing_JSON_GSON_19_10.UserNested;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        serializeUserSimple();
        System.out.println(deserializeUserSimple());
    }
    private static void serializeUserSimple() {
        UserAddress userAddress = new UserAddress("Belarus","Minsk","Bedi","39");
        UserNested userSimple = new UserNested("Peter",
                "spvrent@mail.ru", 53, true,
                      userAddress);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();// для фрматирования json с отступами
        String s = gson.toJson(userSimple);

        File file = new File("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/UserNested/UserNested.json");

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


    private static Object deserializeUserSimple() {

        FileReader reader = null;
        try {
            reader = new FileReader("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/UserNested/UserNested.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();

        UserNested userNested = gson.fromJson(reader, UserNested.class);

        return userNested;
    }
}
