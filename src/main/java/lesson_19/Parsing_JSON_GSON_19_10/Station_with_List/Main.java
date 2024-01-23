package lesson_19.Parsing_JSON_GSON_19_10.Station_with_List;


import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

       printStations(deserialize());
    }

    private static Map<String, List<String>> deserialize() {

        FileReader reader = null;
        try {
            reader = new FileReader("src/main/java/lesson_17/Parsing_JSON_GSON_17_10/Station_with_List/linesToStations.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();

        LinesToStations linesToStations = gson.fromJson(reader,LinesToStations.class);

        return linesToStations.getStations();
    }
    private static void printStations(Map<String, List<String>> stations) {
        for (Map.Entry<String, List<String>> entry : stations.entrySet()) {
            System.out.println("Line: " + entry.getKey());
            for (String station : entry.getValue()) {
                System.out.println(station);
            }
            System.out.println();
        }
    }

}
