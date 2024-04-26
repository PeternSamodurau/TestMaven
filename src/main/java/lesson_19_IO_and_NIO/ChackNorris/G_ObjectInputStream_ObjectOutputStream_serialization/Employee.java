package lesson_19_IO_and_NIO.ChackNorris.G_ObjectInputStream_ObjectOutputStream_serialization;

import java.io.Serializable;

public class Employee implements Serializable {           //ЧТОБЫ сериализовать обьект нужно воспользоваться интерфейсом Serializable
    private final String name;
    private String department;
    transient private final int age;              // transient теперь поле будет выводиться как 0
    private double salary;
    private Car car;

    public Employee(String name, String department, int age, double salary, Car car) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}
