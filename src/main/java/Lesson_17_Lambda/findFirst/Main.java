package Lesson_17_Lambda.findFirst;

//findFirst - возвращает первый элемент стрима

import Lesson_17_Lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

        Student firstStudent = studentList.stream().findFirst().get();         //.get() тк Optional
        System.out.println(firstStudent);

        //.findAny();  возвращает любой элемент стрима соответствующий условию (не угадать какой!!!! во многопоточности)
        Optional<Integer> any = Stream.of(20,30,40)
                .parallel()
                .filter(i-> i > 10)
                .findAny();    // 20 или 30 или 40
        System.out.println(any);
    }
}
