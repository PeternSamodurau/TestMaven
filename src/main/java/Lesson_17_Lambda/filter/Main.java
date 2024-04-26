package Lesson_17_Lambda.filter;

import Lesson_17_Lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<Student> newStudentList = studentList.stream()
                .filter(student -> student.getAge()> 51 && student.getAge()<57)
                .collect(Collectors.toList());
        newStudentList.forEach(System.out::println);

        System.out.println("______________________________________");

        Stream<Student> studentStream = Stream.of(student1, student2, student3, student4, student5);
        List<Student> studentList1 = studentStream.collect(Collectors.toList());
        studentList1.forEach(System.out::println);

        System.out.println("______________________________________");


        Stream.of(1,2,3,4,5,6,7,8,9).filter(integer -> integer % 2 == 0).forEach(System.out::println); // 2 4 6 8
        Stream.of("ski","","ll", "   ","box").filter(s -> !s.isBlank()).forEach(System.out::print);  //skillbox

    }
}
