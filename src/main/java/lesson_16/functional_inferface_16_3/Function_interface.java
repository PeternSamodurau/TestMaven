package lesson_16.functional_inferface_16_3;

//чтобы не писать свои функциональные интерфейсы, существуют готовые функциональные интерфейсы

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//FUNCTION <T, R >
// R apply(T t); возвращает R принимает T t
public class Function_interface {
    public static void main(String[] args) {
        Student student1 = new Student("Peter", 'm', 55, 5, 9.3);
        Student student2 = new Student("Alla", 'f', 25, 3, 6.3);
        Student student3 = new Student("Dron", 'm', 40, 2, 5.3);
        Student student4 = new Student("Sveta", 'f', 45, 1, 8.3);
        Student student5 = new Student("Natasha", 'f', 20, 4, 7.3);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        System.out.println("Найти среднее арифметическое по разным показарелям студентов");

        double res = avgOfSomething(studentList,student -> (double)student.getAge());
        System.out.println(res + " - среднее арифметическое возраста ");

        double res1 = avgOfSomething(studentList, Student::getGrade);
        System.out.println(res1 + " - среднее арифметическое оценки ");
    }
    // найти среднее арифметическое по разным показарелям студентов

    public static double avgOfSomething (List<Student> studentList, Function<Student, Double> studentDoubleFunction){
        double result = 0;
        for (Student st: studentList){
            result += studentDoubleFunction.apply(st);
        }
        result = result/studentList.size();

        return result;
    }
}
