package lesson_19_IO_and_NIO.Skillbox.HomeWork;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static String[] sizeNames =
            {"b", "kb", "Mb", "Gb"};

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "Введите путь к папке или файлу: "
            );
            String path = new Scanner(System.in).nextLine();
            File folder = new File(path);
            String size =
                    getHumanReadableSize(getFolderSize(folder));
            System.out.println(
                    "Размер папки / файла: " + size
            );
        }
    }

    public static long getFolderSize(File file) {
        if (file.isFile() == true) {
            return file.length();
        } else {
            long length = 0;
            File[] files = file.listFiles();
            for (File f : files) {
                length += getFolderSize(f);
            }
            return length;
            //Users/АВС/IdeaProjects
        }
    }
    public static String getHumanReadableSize(long length){
        int power = (int) (Math.log(length) / Math.log(1024));
        double value = length / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100.;

        return roundedValue + " " + sizeNames[power];

    }
}
