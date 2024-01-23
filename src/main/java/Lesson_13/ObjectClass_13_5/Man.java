package Lesson_13.ObjectClass_13_5;

import java.util.Objects;

public class Man {
    private String name;
    private int weight;

    public Man(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;                        // проверка на равенство ссылок
        if (object == null || getClass() != object.getClass()) return false; // проветка переданного объекта на null или к каким классам относятся объекты
        Man man = (Man) object;                                         // приведение переданного объекта
        return weight == man.weight && Objects.equals(name, man.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, weight);
//    }
}
