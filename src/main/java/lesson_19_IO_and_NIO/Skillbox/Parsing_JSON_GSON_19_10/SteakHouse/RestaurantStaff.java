package lesson_19_IO_and_NIO.Skillbox.Parsing_JSON_GSON_19_10.SteakHouse;

public class RestaurantStaff {
    private String name;
    private int age;
    private int salary;

    public RestaurantStaff(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "RestaurantStaff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
