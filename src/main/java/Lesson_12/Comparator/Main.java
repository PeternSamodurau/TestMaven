package Lesson_12.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    // см сначала Comparable
    // Интерфейс Comparator используется для сравнения обьектов, используя НЕ естественный порядок, КОГДА непонятно как сортировать

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(923, "Peter", "Samadurau", 4656));
        employeeList.add(new Employee(446, "Alla", "Svinikova", 3546));
        employeeList.add(new Employee(156, "Dron", "Skripko", 6532));
        employeeList.add(new Employee(15, "Dron", "Skripko", 6532));

        Collections.sort(employeeList, new NameComparator());          //Comparator перебивает Comparable

        System.out.println(employeeList);
    }
}