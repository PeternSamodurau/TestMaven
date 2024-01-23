package lesson_19.FileOutputStriam_FileImputStream_19_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String string = "Quality knows no boundary indeed as everything is " + "\n" +
                "highly preferable whenever it has comprised the best excellence, " + "\n" +
                "if not the relative virtuous aspect. " + "\n" +
                "Informed decision can be made; responsible, " + "\n" +
                "competent and patriotic generation can be produced through reliable machinery--quality schooling." + "\n";

        File file = new File("lesson_19/Parsing_from_Object_to_JSONfile_Jackson/data/test.txt");

        //ЗАПИСЬ
        FileOutputStream fos = new FileOutputStream(file, true);// true текст будет дописываться в конец
                                                       // из программы идет выходной поток символов или байтов
        byte[] buffer = string.getBytes();              // создаем буфер байт, куда помещаем строку
        fos.write(buffer);                              // читаем из буфера

        String string1 = "Hello world!" + "\n";        // дописывает с новой строки
        byte[] buffer1 = string1.getBytes();
        fos.write(buffer1);
        fos.write(buffer1[0]);                           // дописывает элемент массива -Н
        fos.close();

        //ЧПЕНИЕ
        StringBuilder stringBuilder = new StringBuilder();

        FileInputStream fin = new FileInputStream(file);  // в программу идет входной поток символов или байтов, который считывается
        int i = -1;
        while ((i = fin.read()) != -1) {                    // работает как итератор
            stringBuilder.append((char) i);
        }
        fin.close();
        System.out.println(stringBuilder.toString());
    }
}
