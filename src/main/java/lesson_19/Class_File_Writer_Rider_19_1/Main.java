package lesson_19.Class_File_Writer_Rider_19_1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            //ЗАПИСЬ
            File file = new File("/Users/АВС/IdeaProjects/Data/info.txt");

            file.delete();                    // удаляет файл весте с содержимым!!!!!

            PrintWriter pw = new PrintWriter(file);              // создает файл по пути - /Users/АВС/IdeaProjects/Data/info.txt
            pw.println("Hello world!");                          // пишем в файл
            pw.println("Привет мир !");                            // пишем в файл

            for (int i = 0; i < 25; i++){
                pw.write(i + " ");
            }
            pw.flush();
            pw.close();                                           // не забываем закрвать поток!!!



            //ЧТЕНИЕ1
            FileReader in = new FileReader(file);
            int temporary;
            while ((temporary = in.read())!= -1){
                System.out.println(temporary + " - " +(char) temporary);           // выводит utf-8 таблицу
            }
            in.close();

            //ЧТЕНИЕ 2
            Scanner scanner = new Scanner(file);                  //читает токенами (до пробела)
            while (scanner.hasNext()){
                String s = scanner.next();
                System.out.print("Выводит сканер токен" + " - " + s + "\n");
            }
            scanner.close();

            System.out.println();

            //ЧТЕНИЕ 3
            BufferedReader br = new BufferedReader(new FileReader("/Users/АВС/IdeaProjects/Data/info.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            for (; ; ) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                stringBuilder.append(line + "\n");
            }
            br.close();                                            // не забываем закрвать поток!!!
            System.out.println(stringBuilder.toString());


            System.out.println(file.length() + " - " + " длина в байтах ");                    //длина в байтах
            System.out.println(file.lastModified());              // последняя дата изменения в миллисек
            System.out.println(file.isDirectory());                // проверяет директория или нет

            File file1 = new File("/Users/АВС/IdeaProjects");

            File[] files = file1.listFiles();                        // массив файлов в дирректории
            for (File f : files) {
                System.out.println(f.getAbsolutePath());
            }
        } catch (NullPointerException | IOException e) {
            System.err.println("No file find");                       //
            e.getMessage();
        }

    }
}
