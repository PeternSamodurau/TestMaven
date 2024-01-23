package Lesson_18.ModulTest_16_6;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private String number;
    private int year;
    private String owner;
    private List<String> owners = new ArrayList<>();

    public Car(String name, String number, int year, String owner) {
        this.name = name;
        this.number = number;
        this.year = year;
        this.owner = owner;
        owners.add(owner);
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

   public int getYear() {
        return year;
    }

   public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        owners.add(owner);
    }
    public List<String> getOwners(){
        return owners;
    }
    private String privateMethod(){              // если метод приватный, не виден за пределами Car
        return "abc";
    }
    private String privateMethod(String a){       // приватный метод с аргументом
        return "что-то";
    }
    public int somethingInt(int a ){
        return a + 4;
    }
    //метод с исключением - подключение к серверу
    public String getDataFromRemoteServer() throws RuntimeException {
        throw new RuntimeException("error!!!");
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", owner='" + owner + '\'' +
                '}';
    }
}
