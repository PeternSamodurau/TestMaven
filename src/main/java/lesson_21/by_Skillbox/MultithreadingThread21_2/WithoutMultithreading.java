package lesson_21.by_Skillbox.MultithreadingThread21_2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//код представляет собой Java-программу, которая изменяет размер изображений. Вот подробное описание:
//
//В начале программы задается новая ширина изображения newWidth равная 300 пикселям.
//Затем задаются две строки srcFolder и dstFolder, которые представляют собой пути к исходной и целевой папкам соответственно.
// Очистка папки назначения dstFolder
//Создается объект File srcDir, который представляет собой исходную папку.
//Записывается текущее время в миллисекундах в переменную start.
//Получается массив файлов files из исходной папки.
//В цикле for каждый файл из массива files считывается в буферизованное изображение image.
//Если image равно null, то цикл продолжается со следующим файлом.
//Рассчитывается новая высота newHeight изображения на основе новой ширины.
//Создается новое буферизованное изображение newImage с новыми размерами и типом пикселей BufferedImage.TYPE_INT_RGB.
//Затем во вложенных циклах for каждый пиксель исходного изображения считывается и записывается в новое изображение.
//Создается новый файл newFile в целевой папке с тем же именем, что и исходный файл.
//Новое изображение записывается в новый файл в формате jpg.
//Если в процессе возникает исключение IOException, то оно выводится на печать.
//В конце программы выводится продолжительность выполнения программы в миллисекундах.



// СЧИТАЕМ СКОРОСТЬ ПЕРЕЗАПИСИ ФОТО БЕЗ МНОГОПОТОЧНОСТИ
public class WithoutMultithreading {

    private static int newWidth = 300;                              // задаем новую ширину фото

    public static void main(String[] args) {
        String srcFolder = "src/main/java/lesson_21/by_Skillbox/Multithreading21_2/src";       // папка с фотографиями
        String dstFolder = "src/main/java/lesson_21/by_Skillbox/Multithreading21_2/dst";       // папка, куда будут складываться уменьшенные фото (меньше пикселей)

        File dstDir = new File(dstFolder);                                        // Очистка папки назначения
        for(File file: dstDir.listFiles())
            if (!file.isDirectory())
                file.delete();



        File srcDir = new File(srcFolder);                             // обращаемся к исходной папке

        long start = System.currentTimeMillis();                       // стартовое время

        File[] files = srcDir.listFiles();                             //получаем массив файлов фото

        try {
              for (File file: files){

                  BufferedImage image = ImageIO.read(file);            //читает файл в буфер

                  if (image == null){
                      continue;
                  }
                  int newHeight = (int) Math.round(image.getHeight()/(image.getWidth()/(double)newWidth));     // расчитываем новую высоту из новой ширины округляя

                  BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB); // создаем новое фото нового размера, с пикселем TYPE_INT_RGB

                  int widthStep = image.getWidth() / newWidth;            //берем каждый какойто пиксель
                  int heightStep = image.getHeight() / newHeight;

                  for (int x = 0; x < newWidth; x++){
                      for (int y = 0; y < newHeight; y++){
                          int rgb = image.getRGB(x * widthStep, y * heightStep);         // берем пиксели
                          newImage.setRGB(x, y, rgb);                                        //вставляем в итоговое изображение
                      }
                  }
                  File newFile = new File(dstFolder + "/" + file.getName());         //создаем фото в папке dstFolder со старым именем
                  ImageIO.write(newImage, "jpg", newFile);                          // сохраняем фото в формате jpg
              }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Duration: " + (System.currentTimeMillis()-start));                // печатаем сколько по времени все происходило
    }
}
