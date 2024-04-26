package lesson_21_Multithreading.by_Skillbox.Wait_and_Notify_methods_21_10;

public class Parking {

    private int parkingSize = 50;
    private int carCount = 0;

    public synchronized void in(){

        if (carCount == parkingSize){
            try {
                wait();                             // остановливаем поток если кол машин == размеру парковки
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        carCount++;

        System.out.println("Автомобиль завезен + ");

        System.out.println("Cвободных мест :" + (parkingSize - carCount));

        notify();
    }
    public synchronized void out(){

        if (carCount == 0){
            try {
                wait();                                   // если кол маш на парковке == 0 тогда останавливаем поток
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        carCount--;
        System.out.println("Автомобиль вывезен - ");

        System.out.println("Cвободных мест :" + (parkingSize - carCount));

        notify();
    }
}
