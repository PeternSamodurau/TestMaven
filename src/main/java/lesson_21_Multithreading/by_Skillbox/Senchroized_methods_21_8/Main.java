package lesson_21_Multithreading.by_Skillbox.Senchroized_methods_21_8;


import java.util.ArrayList;

public class Main {

    private static ArrayList<Double> doubleArrayList = new ArrayList<>();

    public static void main(String[] args) {


        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            threadArrayList.add(new Thread(Main::someHeavyMethod));

        }
        threadArrayList.forEach(Thread::start);
    }

    private static synchronized void someHeavyMethod(){             // без synchronized не работает   // делаем метод synchronized

        for (int i = 0; i < 100000; i++ ){
            doubleArrayList.add(Math.random()/Math.random());          // заполняем случайными числами деление чтобы было по тяжелее операция
        }
        System.out.println(doubleArrayList.size());
        doubleArrayList.clear();                                        // очищаем
    }
}
