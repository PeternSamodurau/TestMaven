package lesson_19_IO_and_NIO.Skillbox.ObjectOutputStream_ObjectInputStream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("lesson_19_IO_and_NIO/Skillbox/Parsing_from_Object_to_JSONfile_Jackson/data/test.txt");

        //ЗАПИСЬ
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

        String s = "Дмитриев Василий 78000 12.07.2016";       // обьект

        out.writeObject(s + "\n");                              //видим в файле представление объекта в кодах
        out.close();

        //ЧТЕНИЕ
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        String s1 = (String)in.readObject();                    //читаем обьекты из файла
        in.close();

        System.out.println(s1);
    }
}
