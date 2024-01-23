package Lesson_13.extends_13_2;

public class Animal {
    private String name;
    private Wings wings;

    public Animal(String name, Wings wings) {
        this.name = name;
        this.wings = wings;
    }

    public void eat(){
         System.out.println("Animal -I am eating");
     }
     public void sleep(){
         System.out.println("Animal -I am sleep");
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wings getWings() {
        return wings;
    }

    public void setWings(Wings wings) {
        this.wings = wings;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", wings=" + wings +
                '}';
    }
}
