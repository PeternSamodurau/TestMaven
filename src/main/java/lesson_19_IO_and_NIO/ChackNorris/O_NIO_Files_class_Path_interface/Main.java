package lesson_19_IO_and_NIO.ChackNorris.O_NIO_Files_class_Path_interface;

//Path обьект представляет собой путь к файлу или директории

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

public class Main {

    private final static String ABSOLUTEPATH = "C:\\Users\\АВС\\IdeaProjects\\TestMaven\\src\\main\\java\\lesson_19_IO_and_NIO\\ChackNorris\\O_NIO_Files_class_Path_interface\\Files_class_Path_interface.txt";
    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/O_NIO_Files_class_Path_interface/Files_class_Path_interface1.txt";
    private final static String STRING ="Краткие ежедневные занятия помогают накапливать знания.\n" +
            " Исследования доказывают, что студенты, выработавшие привычку регулярно учиться, чаще достигают своих целей.\n" +
            " Выделите немного времени для учебы и установите напоминания с помощью инструментов учебного расписания.";

    public static void main(String[] args) {

        Path filePath = Paths.get(ABSOLUTEPATH);
        System.out.println(filePath.getFileName());
        System.out.println("___________________________________");
        //запись
        try {
            Files.write(Path.of(ABSOLUTEPATH), STRING.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //чтение
        try {
            List<String> list = Files.readAllLines(Path.of(ABSOLUTEPATH));
            list.stream().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("____________________________________________________");

        Path directoryPath = Paths.get("src/main/java/lesson_19_IO_and_NIO/ChackNorris/O_NIO_Files_class_Path_interface/MyDirectory");
        System.out.println(directoryPath.getFileName().getParent());  // нет родителя

        if (!Files.exists(Path.of(PATH))){
            try {
                Files.createFile(Path.of(PATH));             // ИЛИ МОЖНО СОЗДАТЬ ДИРЕКТОРИЮ
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Files.isReadable(Path.of(PATH)));
        System.out.println("________________________________________________");

        try {
            Map<String, Object> fileAttributes = Files.readAttributes(Path.of(PATH),"*"); // все атрибуты файла
            fileAttributes.forEach((key, value)-> System.out.println(key + ":" +value));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {    // копируем из файла в файл, создавая его в директории
            Files.copy(Path.of(ABSOLUTEPATH),
                    Path.of("src/main/java/lesson_19_IO_and_NIO/ChackNorris/O_NIO_Files_class_Path_interface/MyDirectory/text.txt"),
                    StandardCopyOption.REPLACE_EXISTING);       // создавать и позволяет перезаписывать без исключения
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Files.move(.....)  - переместить с удалением, или переименовать перемещая в туже папку с другим именем
        //Files.delete(.....);  - удаляет папки если пустые и файлы
    }
}
