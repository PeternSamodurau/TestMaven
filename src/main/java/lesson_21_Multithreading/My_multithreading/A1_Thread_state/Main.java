package lesson_21_Multithreading.My_multithreading.A1_Thread_state;

public class Main {

    public static final Object lock = new Object();
    public static volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {           // 1. создается поток 1
            synchronized(lock) {
                try {
                    Thread.sleep(5000); // Держим блокировку в течение 5 секунд на обьекте Object lock = new Object();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        thread1.start();              //2. запускается поток 1

        Thread.sleep(1000); // 3. Даем thread1 время на запуск и блокировку

        Thread thread0 = new Thread(new MyClass(), "Thread-0"); //4.После того как главный поток (main) просыпается, он создает второй поток (thread0)
        printThreadState(thread0);    //  Состояние thread0 выводится в консоль. Поскольку thread0 еще не запущен, его состояние должно быть NEW
        thread0.start();  //thread0 запускается RUNNABLE.
        // Он пытается заблокировать объект lock, но поскольку thread1 уже заблокировал этот объект, thread0 переходит в состояние ожидания (WAITING).

        printThreadState(thread0);   // состояние (WAITING)  не печатается почемуто

        Thread.sleep(2000);     //Главный поток (main) засыпает на 2 секунды. В это время thread1 просыпается, освобождает блокировку и завершает свою работу.
        printThreadState(thread0);   // состояние thread0 будет BLOCKED, Причина в том, что thread0 пытается получить блокировку на объекте lock,
        // который в данный момент заблокирован потоком thread1.
        // Поскольку thread1 все еще держит блокировку на lock (поскольку он спит внутри синхронизированного блока),
        // thread0 не может получить доступ к этому блоку и остается в состоянии BLOCKED до тех пор, пока thread1 не освободит блокировку.

        isRunning = false; // isRunning = false; Значение переменной isRunning устанавливается в false.
        // Это приводит к тому, что thread0 выходит из цикла while внутри его run() метода, поскольку условие цикла теперь становится false.

        synchronized(lock) { // Главный поток (main) получает блокировку на объекте lock и вызывает метод notify().
            // Это приводит к пробуждению одного из потоков, ожидающих на этом объекте. В данном случае, это thread0, который был в состоянии WAITING.
            lock.notify();
        }
        Thread.sleep(2000); //Главный поток (main) засыпает на 2 секунды, В это время thread0 продолжает свое выполнение.
        printThreadState(thread0);//Поскольку thread0 был уведомлен и продолжил выполнение, его состояние должно быть RUNNABLE.
        // Однако, поскольку isRunning теперь false, thread0 выходит из цикла while и завершает свою работу.
        // Таким образом, его состояние в этот момент должно быть TERMINATED.

    }
    public static void printThreadState(Thread thread) {
        System.out.println(thread.getName() + " : " + thread.getState());
    }
}