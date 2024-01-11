package lesson_17.Parsing_CSV_to_Object;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException,CsvValidationException {

        FileReader file = new FileReader("src/main/java/lesson_17/Parsing_CSV_to_Object/example.csv");

        List<Person> personList = new CsvToBeanBuilder<Person>(file)
                .withType(Person.class)
                .build()
                .parse();
        for (Person person: personList){
            System.out.println(person.getTitle() + " " + person.getName() + " ," + person.getAge());
        }

    }
}
