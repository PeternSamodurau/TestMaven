package lesson_19_IO_and_NIO.Skillbox.Parsing_JSON_Simple_19_10;

// в maven добавить библиотеку json-simple -1.1.1.jar
public class Main {
    // JSON файл делится на: обьект, переменные (разных типов и true), массивы
    // они могут по разному быть вложжены друг в друга
    public static void main(String[] args) {
        JasonSimpleParser parser = new JasonSimpleParser();
        Root root = parser.parse();

        System.out.println("Root ->  " + root.toString() );
    }

}

