package lesson_21_Multithreading.by_Skillbox.MultithreadingRunnable21_3;

import java.io.File;

public class WithMultithreadingRunnable {
    private static int newWidth = 300;                              // задаем новую ширину фото

    public static void main(String[] args) {
        String srcFolder = "src/main/java/lesson_21/by_Skillbox/MultithreadingRunnable21_3/src";       // папка с фотографиями
        String dstFolder = "src/main/java/lesson_21/by_Skillbox/MultithreadingRunnable21_3/dst";       // папка, куда будут складываться уменьшенные фото (меньше пикселей)

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

        ImageResizerRunnable resizer1 = new ImageResizerRunnable(files1, newWidth, dstFolder, start );
        new Thread(resizer1).start();                                                                      //открываем новый поток и запускаем

        File[] files2 = new File[files.length-middle];                   // разделили массив failes на 2 массива
        System.arraycopy(files, 0, files2, 0, files2.length);

        ImageResizerRunnable resizer2 = new ImageResizerRunnable(files2, newWidth, dstFolder, start );  // открываем второй поток
        new Thread(resizer2).start();                                                                      //открываем новый поток и запускаем

        // можно запустить еще один поток
        new Thread(()->{
            for (int i = 0; i< 1000; i++){
                System.out.println(i);
            }
        }).start();

    }
}


