package lesson_16.functional_inferface_16_3;

import java.util.function.Predicate;

import java.util.ArrayList;

//чтобы не писать свои функциональные интерфейсы существуют готовые функциональные интерфейсы

//PREDICATE
//реализует функцию проверки на соответствие значения какому-либо условию.
// Его единственный абстрактный метод называется -test, принимает один аргумент и возвращает значение типа boolean.

public class Predicate_interface {
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

        // PREDICATE через метод
        System.out.println("PREDICAT__________________________________________________");

        testStudentsPredicate(studentList,student -> student.getGrade()== 9.3);  // первая проверк


        System.out.println("__________________________________________________");

        //метод removeIf() требует PREDICATE
        Predicate<Student> predicate = student -> student.getName().equals("Alla"); // удалили "Alla"
        studentList.removeIf(predicate);
        System.out.println(studentList);

        // короткая запись
        studentList.removeIf(student -> student.getName().equals("Peter")); // удалили "Peter"
        System.out.println(studentList);
        System.out.println("__________________________________________________");

        //обьединяем два условия
       Predicate<Student> p1 = student -> student.getGrade() == 5.3;
        Predicate<Student> p2 = student -> student.getSex() == 'm';
        testStudentsPredicate(studentList, p1.and(p2));                   //выводит "Dron"

        System.out.println("__________________________________________________");

        //одно из условий
        testStudentsPredicate(studentList,p1.or(p2));
        System.out.println("__________________________________________________");
        //отрицание
        testStudentsPredicate(studentList, p1.negate());       // все кроме student.getGrade() == 5.3

    }
    static void  testStudentsPredicate(ArrayList<Student> students, Predicate<Student> studentPredicate) {
        for (Student st : students) {
            if (studentPredicate.test(st)) {
                System.out.println(st);
            }
        }
    }
}
