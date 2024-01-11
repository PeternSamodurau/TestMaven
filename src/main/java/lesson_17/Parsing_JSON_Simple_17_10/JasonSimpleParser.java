package lesson_17.Parsing_JSON_Simple_17_10;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JasonSimpleParser {

    private static final String TAG_NAME_MAIN = "name";
    private static final String TAG_PEOPLE = "people";
    private static final String TAG_ELEMENT = "element";
    private static final String TAG_NAME = "name";
    private static final String TAG_AGE = "age";

    public Root parse() {
        // парсим по ключам - переменным
        Root root = new Root();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("data/json.json")) {    // в try FileReader , чтобы автоматически закрывался

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);                    // чтобы в parse reader нужен FileReader
            String name = (String) rootJsonObject.get(TAG_NAME_MAIN);

            JSONArray peopleJsonArray = (JSONArray) rootJsonObject.get(TAG_PEOPLE);             // JSONArray так как people это массив

            List<People> peopleList = new ArrayList<>();
            for (Object object : peopleJsonArray){
                JSONObject peopleJsonObject = (JSONObject) object;
                String namePeople = (String) peopleJsonObject.get(TAG_NAME);
                long agePeople = (Long) peopleJsonObject.get(TAG_AGE);                // LONG - т к JSON воспринимает int как long

                People people = new People(namePeople, (int) agePeople);                // приводим к int
                peopleList.add(people);
            }

            root.setName(name);
            root.setPeopleList(peopleList);

            return root;

        } catch (Exception e) {
            System.out.println("Parser error " + e.toString());
        }
        return null;
    }
}
