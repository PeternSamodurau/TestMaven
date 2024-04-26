package Lesson_17_Lambda.min_max;

//.min();.max(); требуют Comparator и возвращает объект класа Optional - специальный класс, который хранит результат
//        результата может быть два:
//        - полученное значение, мин или мах
//-empty , мин или мах не найдено, пустое значение

import Lesson_17_Lambda.Student;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Optional<Integer> shortest = Stream.of(1,2,3,4)   // результат пакуется в объект Optional (обертка над null)
                .filter(integer -> integer > 10)
                .max(Integer::compare);                   // max отсутствует
        if (shortest.isPresent()) {
            System.out.println(shortest.get());               // метод get(); для получения
        }else {
            System.out.println("Максимальное значение не найдено!");
        }
        System.out.println("___________________________________________________________");

        // или сразу бросить исключение
//        int max = Stream.of(1,2,3,4)
//                .filter(integer -> integer > 10)
//                .max(Integer::compare)
//                .orElseThrow(()-> new NoSuchElementException());

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

        Student studentMinAge = studentList.stream().min(Comparator.comparingInt(Student::getAge)).get();
        System.out.println(studentMinAge);

        System.out.println("___________________________________________________________");

        Student studentMaxAge = studentList.stream().max(Comparator.comparingInt(Student::getAge)).get();
        System.out.println(studentMaxAge);

    }
}
