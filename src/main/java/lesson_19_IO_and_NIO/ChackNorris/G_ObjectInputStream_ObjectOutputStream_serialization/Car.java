package lesson_19_IO_and_NIO.ChackNorris.G_ObjectInputStream_ObjectOutputStream_serialization;

import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private int id;
    transient private String color;                   // transient теперь поле будет выводиться как null

    public Car(String name, int id, String color) {
        this.name = name;
        this.id = id;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
