package lesson_21_Multithreading.by_ChuckNorris.B_Thread_methods;

public class Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());

        // методы .getName() и getPriority()

        System.out.println("Name of my thread is: " + thread1.getName() + "\n" + "Priority of my thread is: " + thread1.getPriority());
        System.out.println("Name of my thread is: " + thread2.getName() + "\n" + "Priority of my thread is: " + thread2.getPriority());
        System.out.println("____________________________________");

        // установим имена потоков
        thread1.setName("My thread 1");
        thread2.setName("My thread 2");

        // установим приоретет 0-10, но он НЕ ГАРАНТИРОВАН!!!
        thread1.setPriority(1);
        thread2.setPriority(3);

        //или так
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);                  // == ДЕФОЛТНЫЙ 5

        System.out.println("Name of my thread is: " + thread1.getName() + "\n" + "Priority of my thread is: " + thread1.getPriority());
        System.out.println("Name of my thread is: " + thread2.getName() + "\n" + "Priority of my thread is: " + thread2.getPriority());
        System.out.println("____________________________________");

        thread1.start();
        thread2.start();


        // метод sleep
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(3000);                    // Main поспит после каждой итерации 3 сек
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ПОЕХАЛИ!  " + Thread.currentThread().getName() + " - " + i);
        }
        System.out.println("________________________");

        //метод join
        System.out.println("Method main begins");    // стартует поток main
        Thread thread =new Thread(new Employee());
        thread.setName("Thread-MyThread");
        System.out.println("Состояние потока - "+thread.getName()+ " - " + thread.getState());        // выводит состояние потока
        thread.start();                            //стартует поток Employee
        try {
            System.out.println("Состояние потока - "+thread.getName()+ " - " + thread.getState());        // выводит состояние потока
            thread.join(1500);                    // main ждет завершения потока 1,5 сек или быстрее если закончит работу потрок thread
            System.out.println("Состояние потока - "+thread.getName()+ " - " + thread.getState());        // выводит состояние потока
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Состояние потока - "+thread.getName()+ " - " + thread.getState());        // выводит состояние потока
        System.out.println("Method main ends + 1,5 sec");
        System.out.println("Состояние потока - "+thread.getName()+ " - " + thread.getState());        // выводит состояние потока
        System.out.println("_________________________");
    }
}
