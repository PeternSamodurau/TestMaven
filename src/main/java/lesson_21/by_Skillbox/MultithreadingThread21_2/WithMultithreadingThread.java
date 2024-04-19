package lesson_21.by_Skillbox.MultithreadingThread21_2;

import java.io.File;

// СЧИТАЕМ СКОРОСТЬ ПЕРЕЗАПИСИ ФОТО с учетом МНОГОПОТОЧНОСТИ
public class WithMultithreadingThread {

    private static int newWidth = 300;                              // задаем новую ширину фото

    public static void main(String[] args) {
        String srcFolder = "src/main/java/lesson_21/by_Skillbox/Multithreading21_2/src";       // папка с фотографиями
        String dstFolder = "src/main/java/lesson_21/by_Skillbox/Multithreading21_2/dst";       // папка, куда будут складываться уменьшенные фото (меньше пикселей)

        File dstDir = new File(dstFolder);                                        // Очистка папки назначения
        for (File file : dstDir.listFiles())
            if (!file.isDirectory())
                file.delete();


        File srcDir = new File(srcFolder);                             // обращаемся к исходной папке

        long start = System.currentTimeMillis();                       // стартовое время

        File[] files = srcDir.listFiles();                             //получаем массив файлов фото

        int middle = files.length / 2;                                  // делим массив на 2 части

        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0, files1.length);

        ImageResizerThread resizer1 = new ImageResizerThread(files1, newWidth, dstFolder, start );
        resizer1.start();                                                        // запускаем первый поток

        File[] files2 = new File[files.length-middle];                   // разделили массив failes на 2 массива
        System.arraycopy(files, 0, files2, 0, files2.length);

        ImageResizerThread resizer2 = new ImageResizerThread(files2, newWidth, dstFolder, start );
        resizer2.start();                                                        // запускаем второй поток

    }
}

