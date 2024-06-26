package Lesson_17_Lambda.limit;

// Limit - ограничивает количество элементов в стриме

import Lesson_17_Lambda.Student;

import java.util.ArrayList;
import java.util.List;

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

        studentList.stream().filter(student -> student.getAge() > 52).limit(1).forEach(System.out::println);   // лимит 1

    }
}
