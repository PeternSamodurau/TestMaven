package Lesson_14.InterfaceWithDefoltMethod_14_5;

public interface Printer {
    void printBlackAndWhite();                        // если абстрактных методов много, то их все нужно переопределить,
    default void printColor() {                      //что бы не переопределять метод в классе, его помечают как default
        System.out.println("Print color");
    }
}
