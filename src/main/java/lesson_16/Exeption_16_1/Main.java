package lesson_16.Exeption_16_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] strings = {"Perter","Alla","Sveta"};
        try {
            String s = strings[3];      // нет 3 индекса но код работает дальше
            System.out.println(s);
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("1- После код будет работать");
        File file = new File("lesson_17/Parsing_from_Object_to_JSONfile_Jackson/data/staff.txt");       // файл найден
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");       // если файл не найден код работает дальше
        }
        System.out.println("2-После код будет работать");
        System.out.println(scan());
    }
    // или метод c исключением
    public static List<String> scan() throws FileNotFoundException{
        File file = new File("lesson_17/Parsing_from_Object_to_JSONfile_Jackson/data/staff.txt");
        Scanner scanner = new Scanner(file);
        List<String> strings = new ArrayList<>();
        while (scanner.hasNextLine()){
            strings.add(scanner.nextLine());
        }
        return strings;
    }

}
