package Lesson_14.InterfaceWithDefoltMethod_14_5;

public class Main {



    public static void main(String[] args) {
        Printer printer = new SimplePrinter();
        printer.printBlackAndWhite();                // к абстрактному методу есть доступ
        printer.printColor();                        // к дефолтному методу есть доступ
    }
}
