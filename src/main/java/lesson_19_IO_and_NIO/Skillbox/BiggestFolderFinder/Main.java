package lesson_19_IO_and_NIO.Skillbox.BiggestFolderFinder;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/java/lesson_17/BiggestFolderFinder/data";
        long sizeLimit = 0;      // лимит отсеивания папок 50Mb

        File fail = new File(path);
        Node root = new Node(fail, sizeLimit);

        FolderSizeCalculat calculat = new FolderSizeCalculat(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculat);
        System.out.println(root);

      //  System.out.println(SizeCalculator.getSizeFromHumanReadable("235K"));


      //  System.out.println("размер папки/файла = " + " " + SizeCalculator.getHumanReadableSize(50000));
    }
}
