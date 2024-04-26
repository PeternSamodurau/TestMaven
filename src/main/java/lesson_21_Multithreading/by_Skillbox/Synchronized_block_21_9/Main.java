package lesson_21_Multithreading.by_Skillbox.Synchronized_block_21_9;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Double> doubleArrayList = new ArrayList<>();

    public static void main(String[] args) {


        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threadArrayList.add(new Thread(Main::someHeavyMethod));

        }
        threadArrayList.forEach(Thread::start);
    }

    private static void someHeavyMethod() {

        for (int i = 0; i < 100000; i++) {

            double value = Math.random() / Math.random();

            synchronized (doubleArrayList) {
                doubleArrayList.add(value);          // можно синхронизировать только блок кода где ошибка, если не беспокоят неверные данные
            }
//            synchronized (Main.class) {
//                doubleArrayList.add(value);          // или так синхронизируемся по всем экземплярам класса
//            }
        }
        System.out.println(doubleArrayList.size());
        doubleArrayList.clear();                                        // очищаем
    }
}
