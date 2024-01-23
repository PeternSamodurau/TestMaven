package Lesson_14.Polymorphism_14_6;

public class Main {
    //ПОЛИМОРФИЗМ - МНОЖАСТВО ФОРМ

    //B языке программирования Java полиморфизм позволяет использовать один и тот же метод
    // для разных классов, которые наследуются от одного общего суперкласса или реализуют один общий интерфейс.
    //Это называется динамическим полиморфизмом или полиморфизмом времени выполнения.

    public static void main(String[] args) {
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();

        // позднее связывание - переопределяем метод eat() в классах Cat и Dog

        test(animal1);
        test(animal2);
    }
    public static void test(Animal animal){             //один метод обслуживает общего родителя
        animal.eat();
    }
}
