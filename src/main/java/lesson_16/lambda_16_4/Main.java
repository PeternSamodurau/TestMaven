package lesson_16.lambda_16_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
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


        // в качестве второго параметра единственный абстрактный метод функционального интерфейса StudentCheck
        testStudents(studentList, new StudentCheck() {
            @Override
            public boolean check(Student st) {
                return st.getAge ()< 30;
            }
        });
        System.out.println("__________________________________________________");

        // или так с помощью лямбда

        testStudents(studentList,(Student st)-> {return st.getAge() < 30;});
        System.out.println("__________________________________________________");

        // укарачиваем
        //краткая форма если абстрвкт метод имеет только один параметр
        testStudents(studentList,st-> st.getAge() < 30);
        System.out.println("__________________________________________________");

        //краткая форма если абстрвкт метод имеет только один параметр, если несколько
        testStudents1(studentList,(st,i)-> (st.getAge() > i));
        System.out.println("__________________________________________________");

        // для повторного использования лямбда выражениe - в переменную
        StudentCheck studentCheck = s -> s.getAge() < 25;
        testStudents(studentList,studentCheck);


       // объявление ссылки на MyInterface
        MyInterface pi = ()-> 3.14;
        System.out.println(pi.getPiValue());

        //сортировка листа
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getCourse()-o2.getCourse();
            }
        });
        studentList.forEach(System.out::println);

    }

    static void  testStudents(ArrayList<Student> students, StudentCheck sc) {
        for (Student st : students) {
            if (sc.check(st)) {
                System.out.println(st);
            }
        }
    }
    static void  testStudents1(ArrayList<Student> students, SomeFunctionInterface sc) {
        for (Student st : students) {
         if (sc.doSomeThing(st, 50)) {
                System.out.println(st);
            }
        }
    }

}


