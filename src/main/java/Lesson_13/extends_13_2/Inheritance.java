package Lesson_13.extends_13_2;

//Inheritance наследование
//отношение между классами,при котором характеристики одненго класса передаются другому классу без
//необходимости их повторного определения
//повторное использование кода уже существующих классов
//моделирование наследования, существующего в предметной области

public class Inheritance {
    public static void main(String[] args) {
        Animal animal = new Animal("Vasia", new Wings("BIG"));
        System.out.println(animal);

        animal.setName("Misha");
        System.out.println("My name is - " + animal.getName());

        animal.eat();
        animal.sleep();

        System.out.println("_______________________________________");

        Ostrich ostrich = new Ostrich("Anna", new Wings("SMALL"), 10);
        System.out.println(ostrich);

        ostrich.eat();               // вызывается переопределенный метод
        ostrich.sleep();
        ostrich.hideHeard();

    }
}
