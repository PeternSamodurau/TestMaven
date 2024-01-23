package Lesson_14.Interface_14_3;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Main {
    // implementation - реализация, осуществление
    // интерфейс более высокий уровень абстракции, чем абстрактный класс, он что то делает и не содержит реализацию методов,
    // не содержат конструкторы и переменные за некоторыми исключениями
    // интерфейс описывает набор методов, реализуемых в классах где они переопределяются
    // методы всегда public и не содержат реализацию
    // не содержат переменных и конструкторов
    // могут содержать константы
    // могут содержать static методы
    // могут содержать default методы
    // один класс может имплементировать несколько интерфейсов сразу

    //делятся на:
    // поведенческие - устанавливают общий набор методов для классов, где ни переопределяются
    // List, Collection, Comparable ....


    // маркерные - не содержат методов, обозначают дополнительные возможности классов (маркируют их)
    // Cloneable, Serializable ...
    // у них нет методов, они помечают обьекты определенным образом

    public static void main(String[] args) {
        Person person1 = new Person("Peotr", "Samadurau");
        Person person2 = new Person("Andrey", "Bkripko");
        Person person3 = new Person("Andrey", "Akripko");

        List<Person> personList = Arrays.asList(person1, person2, person3);
        personList.forEach(person -> {
            person.canSleep();
            System.out.print(person + " ");
        });
        System.out.println();
        personList.stream().sorted(Person::compareTo).forEach(System.out::println);


    }
}
