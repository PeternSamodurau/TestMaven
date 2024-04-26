package lesson_19_IO_and_NIO.ChackNorris.A_File_writer;

//Stream для работы с текстовым файлом.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        final String string = "Stream - поток для работы с файлами - упорядоченная последовательность данных\n" +
                "Stream - делятся на работающие с байтами и с символами\n" +
                "Файлы делят на читабельные для человека - text files. и нечитабельные для человека - binary files\n" +
                "При работе с текстовыми и бинарными файлами необходимо использовать разные типы Stream.\n";

        final String string1 = "допишем еще что-то\n";

        final String path = "rc/main/java/lesson_19_IO_and_NIO/ChackNorris/A_File_writer/File_writer.txt";
         // специально ошибка в path- добавь s
        //      FileWriter fileWriter = null;


        // ЛУЧШЕ КАК В Try_with_resource

        Optional<FileWriter> fileWriter = Optional.empty();
        // Эта строка создает объект Optional, который может содержать объект FileWriter.
        // В данном случае, Optional.empty() создает “пустой” Optional, то есть Optional, который не содержит значение.
        // Это аналогично тому, как бы вы могли присвоить null переменной,
        // но с использованием Optional вы получаете дополнительные утилиты для работы с возможно отсутствующими значениями.

        //Использование Optional может помочь предотвратить NullPointerException,
        // поскольку вы можете проверить, содержит ли Optional значение, прежде чем пытаться его использовать, с помощью метода isPresent().
        // Это может сделать ваш код более безопасным и понятным, поскольку вы явно обрабатываете случаи, когда значение может отсутствовать.

        try {
            fileWriter = Optional.of(new FileWriter(path,true));  // true - будет постоянно дописывать, а не перезаписывать
            // Здесь Optional.of(T value) - это статический метод, который возвращает Optional, содержащий указанное значение,
            // если таковое имеется, иначе выбрасывает исключение NullPointerException.
            // В данном случае, он пытается создать новый объект FileWriter с указанным путем к файлу.
            // Если FileWriter успешно создается, он оборачивается в Optional и присваивается переменной fileWriter.
            // Если при создании FileWriter возникает исключение (например, файл не найден), то исключение будет выброшено,
            // и fileWriter останется пустым Optional.

            for (int i = 0; i < string.length(); i++) {

                fileWriter.get().write(string.charAt(i));  // идет посимвольная запись в файл

            }

            fileWriter.get().write(string1);            // можно просто передать стринг

            System.out.println("Done!");

        } catch (IOException e) {
            System.out.println("Файл не записан!!!!" + e);

        } finally {
            try {
                if (fileWriter.isPresent()) {

                    fileWriter.get().close();          // обязательно закрывать - не запишется!!!
                }
            } catch (IOException e) {
                System.out.println("Не ЗАКРЫТ!!!!" + e); //выводится только при ошибке закрытия

            }
        }
    }
}
