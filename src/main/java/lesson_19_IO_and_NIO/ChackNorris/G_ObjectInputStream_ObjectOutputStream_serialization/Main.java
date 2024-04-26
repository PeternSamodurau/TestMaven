package lesson_19_IO_and_NIO.ChackNorris.G_ObjectInputStream_ObjectOutputStream_serialization;

//Serialization - процесс преобразования обьекта в последовательность байт
//передать список работников другому программисту, сохранив в файл байты

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// ArrayList уже имплементирует интерфейс Serializable и String тоже

public class Main {

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/G_ObjectInputStream_ObjectOutputStream_serialization/employeesOutIn1.bin";

    public static void main(String[] args) {

        List<String> employees = new ArrayList<>();

        employees.add("Peter1");
        employees.add("Peter2");
        employees.add("Peter3");
        employees.add("Peter4");
        employees.add("Peter5");

        //запись в файл

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PATH))){

            outputStream.writeObject(employees);
            System.out.println("Done!");

        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //чтение из файла

        List<String> employees1; // будем складывать сюда

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PATH))){

            employees1 = (ArrayList)inputStream.readObject();  //// inputStream.readObject() возвращает Object, приводим к (ArrayList)
            System.out.println(employees1);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
