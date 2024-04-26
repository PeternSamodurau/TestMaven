package Lesson_17_Lambda.chaining;

// Chaining - сцепление, связывание
//В Java нет встроенного метода с названием chaining().
// Однако, термин “method chaining” (или “цепочка вызовов методов”) относится к подходу программирования,
// при котором методы объекта вызываются последовательно.
// Каждый метод в цепочке возвращает объект, что позволяет вызвать следующий метод непосредственно

import Lesson_17_Lambda.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{38,5,4,96,6,7,855,564,9};
        int result = Arrays.stream(array)
                .filter(v -> v % 2 == 1)                       //оставляем нечетные  5,7,855,9
                .map(e -> {if (e%3==0){e=e/3;}return e;})            //5,7,285,3
                .reduce((a,e)-> a+e).getAsInt();                     //5+7+285+3 =300
        System.out.println(result);
        System.out.println("________________________________________________________");

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

        studentList.stream()
                .filter(student -> student.getSex()=='f')
                .sorted(Comparator.comparing(Student::getAge))
                .peek(student -> student.setName(student.getName().toUpperCase()))
                .forEach(System.out::println);
    }
}
