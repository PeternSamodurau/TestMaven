package Lesson_17_Lambda.collect;

// collect - преобразует поток в коллекцию
//groupingBy - группирует по
//partitioning - разделяет по

import Lesson_17_Lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Peter", 'm', 53, 1, 9.3);
        Student student2 = new Student("Alla", 'f', 50, 2, 8.3);
        Student student3 = new Student("Dron", 'm', 52, 3, 7.3);
        Student student4 = new Student("Sveta", 'f', 57, 1, 5.3);
        Student student5 = new Student("Natasha", 'f', 51, 2, 5.3);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        System.out.println("Сгруппируем по курсам");

        Map<Integer, List<Student>> map = studentList.stream().peek(student -> {
            student.setName(student.getName().toUpperCase());//сделали имена заглавными
        }).collect(Collectors.groupingBy(Student::getCourse)); // сгруппировали по курсу

        for (Map.Entry<Integer, List<Student>>entry :map.entrySet()){
            System.out.println("Course " + entry.getKey() + " : " + "\n" + entry.getValue());
        }
        System.out.println("______________________________________________");

        System.out.println("Разделим студентов на 2 группы кто получает высокую оценку true и низкую false");

        Map<Boolean, List<Student>> map1 = studentList.stream().collect(Collectors.partitioningBy(student -> student.getGrade() > 7));

        for (Map.Entry<Boolean, List<Student>> entry: map1.entrySet()){
            System.out.println("Grade " + entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("______________________________________________");

        System.out.println("Получим Мар разными способами");

        Map<String,Character> map2 = Stream.of(student1,student2,student3,student4,student5)
                .collect(Collectors.toMap(Student::getName,Student::getSex));
        System.out.println(map2);
        System.out.println("______________________________________________");

        Map<String,Integer> map3 = Stream.of("a","a","c","b","c","a")
                .collect(Collectors.toMap(Function.identity(),(s)-> 1,(existing, current)-> ++ existing));
        System.out.println(map3);
        System.out.println("______________________________________________");

        // или так с помощью .groupBy() подсчет количества элементов через группировку данных
        Map<String,Long> map4 = Stream.of("a","a","c","b","c","a")
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map4);
        System.out.println("______________________________________________");

        // или получить сумму всех оценок студентов

        Map<String,Double> map5 = Stream.of(student1,student2,student3,student4,student5)
                .collect(Collectors.groupingBy(Student::getName,Collectors.summingDouble(Student::getGrade)));
        System.out.println(map5);
    }
}
