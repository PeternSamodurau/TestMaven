package lesson_19_IO_and_NIO.ChackNorris.G_ObjectInputStream_ObjectOutputStream_serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// ЧТОБЫ сериализовать обьект нужно воспользоваться интерфейсом Serializable
// чтобы не записывалась часть информации об обьекте, поле помечают как transient

public class Main1 {

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/G_ObjectInputStream_ObjectOutputStream_serialization/employeesOutIn2.bin";

    public static void main(String[] args) {

        Employee employee1 = new Employee("Peter1", "IT", 28, 500, new Car("Honda", 12313131,"black"));
        Employee employee2 = new Employee("Peter2", "IT", 27, 1500, new Car("Honda", 546546,"black"));
        Employee employee3 = new Employee("Peter3", "IT", 26, 2500, new Car("Honda", 12313131,"black"));
        Employee employee4 = new Employee("Peter4", "IT", 25, 3500, new Car("Honda", 12313131,"black"));
        Employee employee5 = new Employee("Peter5", "IT", 24, 4500, new Car("Honda", 12313131,"black"));

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);

       // записываем в файл работника с максимальной з/п
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {

            Employee maxSalaryEmployee = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();

            outputStream.writeObject(maxSalaryEmployee);

            System.out.println("Write done!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // прочитаем из файла кто лучший работник

        Employee bestEmployee;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PATH))){

            bestEmployee = (Employee) inputStream.readObject();   // inputStream.readObject() возвращает Object, приводим к (Employee)
            System.out.println(bestEmployee);
            System.out.println("Read done!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
