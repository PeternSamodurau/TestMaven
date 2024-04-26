package Lesson_17_Lambda.flatMap;

import Lesson_17_Lambda.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//flatMap - когда надо работать не с коллекциями а с елементами элементов коллекций

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Peter", 'm', 53, 4, 9.3);
        Student student2 = new Student("Alla", 'f', 50, 5, 8.3);
        Student student3 = new Student("Dron", 'm', 52, 3, 3.3);
        Student student4 = new Student("Sveta", 'f', 57, 1, 5.3);
        Student student5 = new Student("Natasha", 'f', 51, 2, 1.3);

        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(student1);
        studentList1.add(student2);
        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(student3);
        studentList2.add(student4);
        studentList2.add(student5);

        Faculty faculty1 = new Faculty("Economic", studentList1);
        Faculty faculty2 = new Faculty("Art",studentList2);

        List<Faculty> facultyList = Arrays.asList(faculty1, faculty2);

        System.out.println("Выведем все имена студентов из всех факультетов");

        facultyList.stream()
                .flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
                .forEach(student -> System.out.println(student.getName()));
                    //получаем List<Student>., вызываем опять stream(), получаем имена



    }
}
