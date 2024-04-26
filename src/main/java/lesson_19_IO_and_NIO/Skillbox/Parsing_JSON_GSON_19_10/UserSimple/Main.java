package lesson_19_IO_and_NIO.Skillbox.Parsing_JSON_GSON_19_10.UserSimple;

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

        UserSimple userSimple = new UserSimple("Peter",
                "spvrent@mail.ru", 53, true);

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();// для фрматирования json с отступами
        String s = gson.toJson(userSimple);

        File file = new File("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/UserSimple/UserSimple.json");

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
            reader = new FileReader("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/UserSimple/UserSimple.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();

        UserSimple userSimple = gson.fromJson(reader, UserSimple.class);

        return userSimple;
    }
}
