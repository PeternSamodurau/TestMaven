package lesson_19_IO_and_NIO.Skillbox.Parsing_XML_DOM_19_9_1;

public class Main {

    // ИСПОЛЬЗУЕТСЯ ДЛЯ ПАРСИНГА XML С НЕБОЛЬШИМ КОЛИЧЕСТВОМ ВЛОЖЕНИЙ, Т К КОД РАЗРОСТАЕТСЯ !!!!
    //dom - библиотека встроенная в jdk

    public static void main(String[] args) throws Exception {
    DomParser parser = new DomParser();
    Root root = parser.parse();
    }
}
