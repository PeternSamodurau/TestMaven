package lesson_19.Files_19_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //ЗАПИСЬ
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i<= 10; i++){
            arrayList.add(Integer.toString(i));
        }
        Files.write(Paths.get("/Users/АВС/IdeaProjects/Data/info.txt"), arrayList);

        //ЧТЕНИЕ
        StringBuilder builder = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get("/Users/АВС/IdeaProjects/Data/info.txt"));
        lines.forEach(line -> builder.append(line + " " ));
        System.out.println(builder.toString());
    }
}
