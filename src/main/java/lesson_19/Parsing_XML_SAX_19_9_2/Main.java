package lesson_19.Parsing_XML_SAX_19_9_2;

public class Main {
    // ИСПОЛЬЗУЕТСЯ ДЛЯ ПАРСИНГА XML, ДЛЯ БОЛЬШИХ ВЛОЖЖЕНИЙ ,СОБЫТИЙНАЯ МОДЕЛЬ
    public static void main(String[] args) {
     SaxMyParser parser = new SaxMyParser();
     Root root = parser.parser();
        System.out.println("Root -> " + root.toString());
    }
}
