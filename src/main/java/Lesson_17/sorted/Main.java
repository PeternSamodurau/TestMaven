package Lesson_17.sorted;

//сортирует элементы стрима если классы стрима имплемнтировали Comporable иначе требуется Comparator

import Lesson_17.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Stream.of("SFAF","FWEGFG","ADAFQFW").sorted().forEach(s -> System.out.print(" " + s));

        System.out.println("_____________________________________________");

        List<Integer> integerList = Stream.of(new Integer[]{90,45,62,8,5}).sorted().collect(Collectors.toList());
        integerList.forEach(System.out::println);

        System.out.println("_____________________________________________");

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

        List<Student> studentList1 = studentList.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList()); // по имени
        studentList1.forEach(System.out::println);

        System.out.println("_____________________________________________");

        Stream.of(List.of(1,6,3),List.of(8,4),List.of(1))
                .sorted(Comparator.comparing(List::size))
                .forEach(s -> System.out.print(" " + s));


    }
}
