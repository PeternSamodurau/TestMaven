package lesson_21_Multithreading.by_ChuckNorris.F_Data_race_Senchronized_method;

public class MyClass implements Runnable{
   // volatile int count = 0;                       // volatile не сработает, т к 10 потоков меняют значение переменной
    int count = 0;

    @Override
    public synchronized void run() {                         //ПИШЕМ КЛЮЧЕВОЕ СЛОВО synchronized
        for (int i = 0; i< 3; i ++){
            count++;
            System.out.println(Thread.currentThread().getName() + " " + count + " ");
                                                              // КАЖДЫЙ из 10 ПОТОКов ЗАХОДИТ 3 РАЗА
        }
    }
}
