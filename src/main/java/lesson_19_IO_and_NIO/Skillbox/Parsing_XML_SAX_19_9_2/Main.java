package lesson_19_IO_and_NIO.Skillbox.Parsing_XML_SAX_19_9_2;

public class Main {
    // ИСПОЛЬЗУЕТСЯ ДЛЯ ПАРСИНГА XML, ДЛЯ БОЛЬШИХ ВЛОЖЖЕНИЙ ,СОБЫТИЙНАЯ МОДЕЛЬ
    public static void main(String[] args) {
     SaxMyParser parser = new SaxMyParser();
     Root root = parser.parser();
        System.out.println("Root -> " + root.toString());
    }
}
