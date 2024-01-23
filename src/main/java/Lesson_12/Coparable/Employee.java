package Lesson_12.Coparable;

public class Employee implements Comparable<Employee> {        //имплементируем интерфейс, переопределяем метод
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
        if (this.id == o.id) {
            return 0;
        } else if (this.id < o.id) {
            return -1;
        } else return 1;                      //если текущий объект > Employee тo возвращается положительное число
                                              //если текущий объект < Employee тo возвращается отрицательное число
                                              //если текущий объект = Employee тo возвращается 0
       // return this.id-o.id;                  в основном пишут так
        // return this.id.compareTo(o.id);        // если Integer id;  редко
       // return this.name.compareTo(o.name);      // для сортировки по имени

//        int res = this.name.compareTo(o.name);              // по имени и фамилии
//        if (res == 0){
//            res = this.surName.compareTo(o.surName);
//        }
//        return res;
    }
}
