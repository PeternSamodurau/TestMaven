package Lesson_17.map;

import Lesson_17.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// методы стрима не меняют содержимое коллекций
public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Peter", 'm', 53, 4, 9.3);
        Student student2 = new Student("Alla", 'f', 50, 5, 8.3);
        Student student3 = new Student("Dron", 'm', 52, 3, 3.3);
        Student student4 = new Student("Sveta", 'f', 57, 1, 5.3);
        Student student5 = new Student("Natasha", 'f', 51, 2, 1.3);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        studentList.forEach(System.out::println);
        System.out.println("________________________________________________")
        ;
        System.out.println("Допустим хотим вместо имен String поставить длинну строки Integer");

        studentList.stream()
                .map(student -> student.getName().length())
                .forEach(System.out::println);  // ТОЛЬКО ВЫВОДИТ НОВЫЙ ПОТОК

        System.out.println("НЕ МЕНЯЕТ ЛИСТ!!!!!!!");
        studentList.forEach(System.out::println);

        System.out.println("Обрабатывает каждый элемент стрима типа T -Student  в тип R -Integer, получаем стрим типизированный по R" + "\n" +
                "далее с помощю метода collect(Collectors.toList());  можно поместить поток в List<Integer> ");

        List<Integer> streamInteger = studentList.stream()
                .map(student -> student.getName().length() + 100)
                .collect(Collectors.toList());

        System.out.println(streamInteger);
        System.out.println("__________________________________________________________");

        System.out.println("Получим стрим из массива");
        int[] array = {5, 4, 3, 2, 8};
        int[] array1 = Arrays.stream(array).map(i -> i % 2).toArray();        // в другой массив
        System.out.println(Arrays.toString(array1));

    }
}
