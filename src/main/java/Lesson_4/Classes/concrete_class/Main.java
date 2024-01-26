package Lesson_4.Classes.concrete_class;

// Конкретный класс
//Обычный класс, который реализует все свои методы и не содержит абстрактных методов.
// Если он реализует все свои методы, конкретный класс может расширять свой родительский класс, абстрактный класс или интерфейс.

public class Main extends Person implements AddSomething{
    public static void main(String[] args) {
        int p = sum(10, 8);
        System.out.println("Sum: " + p);
    }
    static int sum(int x, int y) {
        return x + y; }
}
// может быть только один public класс
abstract class Person{

}
