package Lesson_12.Coparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    // Интерфейс Comparable используется для сравнения обьектов, используя естественный порядок

    public static void main(String[] args) {

       //проблем с сортировкой нет, т к это String
        List<String> list = new ArrayList<>();
        list.add("Peter");
        list.add("Alla");
        list.add("Sveta");
        list.add("Dron");

        Collections.sort(list);           //метод интерфейса Collections

        System.out.println(list);         //сортировка идет по лексиграфическому сравнению

        // если свои объкты то sort не сработает

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(923,"Peter", "Samadurau",4656));
        employeeList.add(new Employee(446,"Alla", "Svinikova",3546));
        employeeList.add(new Employee(156,"Dron", "Skripko",6532));

        Collections.sort(employeeList);
        // без переопределения метода compareTo интерфейса Comparable, не известно как сравнивать обьекты
        // имплементируем интерфейс Comparable в Employee
        // теперь можно сравнить по id
        System.out.println(employeeList);
    }
}
