package lesson_21.by_Skillbox.MultithreadingRunnable21_3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResizerRunnable implements Runnable {
    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;

    public ImageResizerRunnable(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (File file : files) {

                BufferedImage image = ImageIO.read(file);            //читает файл в буфер

                if (image == null) {
                    continue;
                }
                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));     // расчитываем новую высоту из новой ширины округляя

                BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB); // создаем новое фото нового размера, с пикселем TYPE_INT_RGB

                int widthStep = image.getWidth() / newWidth;            //берем каждый какойто пиксель
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
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
        System.out.println("Finished after star: " + (System.currentTimeMillis()-start) + "ms");
    }
}
