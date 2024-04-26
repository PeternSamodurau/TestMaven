package lesson_21_Multithreading.by_ChuckNorris.F_Data_race_Senchronized_method;

//Data race - гонка данных, это проблема, которая может возникнуть
// когда два и более потоков обращаются к одной и тойже переменной
// и как минимум 1 поток ее изменяет

//synchronized синхронизирует потоки, ставит замок чтобы потоки работали по очереди

public class Main {

    public static int count = 0;

    public static void main(String[] args) {

        MyClass myClass = new MyClass();

        for (int i = 0; i < 10; i++) {

            new Thread(myClass).start();

        }

        // или так  Объект lock используется как монитор для синхронизации. Это помогает предотвратить условия гонки

//        final Object lock = new Object();
//
//        for (int i = 0; i < 10; i++) {
//
//            Runnable task = () -> {
//
//                for (int j = 0; j < 3; j++) {
//
//                    synchronized (lock) {
//                        count++;
//                        System.out.println(Thread.currentThread().getName() + " " + count + " ");
//                    }
//                }
//            };
//
//            Thread thread = new Thread(task);
//            thread.start();
//
//        }
    }
}