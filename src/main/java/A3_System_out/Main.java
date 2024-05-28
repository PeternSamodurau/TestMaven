package A3_System_out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        System.err.println("Hello World!!!");
        try {
            // Создаем объект для записи в файл "out.txt"
            PrintStream fileOutput = new PrintStream(new FileOutputStream("src/main/java/A3_System_out/out.txt"));

            // Перенаправляем стандартный вывод в файл
            System.setOut(fileOutput);

            // Ваш код
            System.out.println("Hello World!!!");
            System.err.println("Hello World!!!");    // НЕ ЗАПИШЕТСЯ В ФАЙЛ
            // Закрываем файл после использования
            fileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

