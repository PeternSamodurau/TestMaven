package lesson_15.Lambda_15_10;

import java.util.ArrayList;

public class StudentsInfo {
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

        studentList.forEach(System.out::println);

        StudentsInfo studentsInfo = new StudentsInfo();
        // в качестве второго параметра ананимный класс StudentCheck
        studentsInfo.testStudents(studentList, new StudentCheck() {
            @Override
            public boolean check(Student st) {
                return st.getAge ()< 30;
            }
        });
        System.out.println("__________________________________________________");
        // или так с помощью лямбда, в качестве второго параметра единственный абстрактный
        // метод Функционального интерфейса StudentCheck
        studentsInfo.testStudents(studentList,(Student st)-> {return st.getAge() < 30;});
        System.out.println("__________________________________________________");
        // укарачиваем
        studentsInfo.testStudents(studentList,st-> st.getAge() < 30);
        System.out.println("__________________________________________________");
        // для повторного использования лямбда выражениe - в переменную
        StudentCheck studentCheck = st -> st.getAge() < 30;
        studentsInfo.testStudents(studentList,studentCheck);


       // объявление ссылки на MyInterface
        MyInterface pi = ()-> 3.14;
        System.out.println(pi.getPiValue());
    }

    void testStudents(ArrayList<Student> students, StudentCheck sc) {
        for (Student st : students) {
            if (sc.check(st)) {
                System.out.println(st);
            }
        }
    }



}


