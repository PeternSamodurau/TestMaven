package Lesson_17_Lambda.mapToInt;

//MapToInt - возвращает IntStream
//MapToDouble и тд
import Lesson_17_Lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Integer> course = studentList.stream()
                .mapToInt(Student::getCourse)
                .boxed()
                // метод boxed(); упаковывает int course в Integer
                .collect(Collectors.toList());
        System.out.println(course);



    }
}
