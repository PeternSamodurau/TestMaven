package Lesson_12.Comparator;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String surName;
    private int salary;

    public Employee(int id, String name, String surName, int salary) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {        //возвращает int
        if (this.id == o.id) {                // используем сначала естественную сортировку интерфейса Comparable
            return 0;
        } else if (this.id < o.id) {
            return -1;
        } else return 1;
    }
}