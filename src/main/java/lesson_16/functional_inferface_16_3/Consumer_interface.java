package lesson_16.functional_inferface_16_3;

//чтобы не писать свои функциональные интерфейсы, существуют готовые функциональные интерфейсы

import java.util.ArrayList;
import java.util.function.Consumer;

//CONSUMER - потребитель
// void accept(T t) - принимает объет T ничего не возвращает
public class Consumer_interface {
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
        System.out.println("_____________________________________________");

        changeStudent(studentList.get(0), student -> {  // у 0 элемента меняем
            student.setName("PETER SAMADURAU");         // имя
            student.setAge(50);                         // возраст
            student.setGrade(10);                       //оценку
        });
        System.out.println("У элемента 0 меняем имя возраст, оценку");
        studentList.forEach(System.out::println);

    }

    public static void changeStudent(Student student, Consumer<Student> studentConsumer) {
        studentConsumer.accept(student);
    }
}
