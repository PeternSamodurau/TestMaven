package lesson_21.My_multithreading.G_IncrementCounterUnsafeDemo;

//Процесс имеет stack и heap память
//Stack хранит локальные переменные, стек вызова методов и аргументы методов
//Heap хранит обьекты

//У каждого потока есть своя stack память и общая heap память

public class IncrementCounterUnsafeDemo {
    static Integer counter = 0;

    // не выводит 20000
    // тк цикл первого потока начинает работать, присваевает i 1,2,3 итд, включается второй поток и опять перезаписывает 1,2,3 поверху

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter: " + counter);
    }
}
