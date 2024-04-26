package lesson_21_Multithreading.by_ChuckNorris.A_Multithreading;

//Multithreading - принцип построения программы, при котором несколько блоков кода могут выполняться одновременно
//goal - повысить производительность, и парралельность исполнения процессов - concurrency
// в одноядерных процессорай многопоточность достигаетсяблагодаря технологии context switch - переключается между заданиями

//В большинстве случаев интерфейс Runnable следует использовать, если вы планируете переопределить только метод run() и никакие другие методы Thread.
// Это важно, потому что классы не должны наследоваться, если программист не намерен изменять или улучшать основное поведение класса.
public class Main {

    public static void main(String[] args) {

        Thread myThread1 = new Thread(new MyClass_1());    // при использовании интерфейса передаем обьект

        MyClass_2 myClass_2 = new MyClass_2();

        // вывод в консоль будет не по порядку, т к 4 процессора будут хаотично захватывать вывод в консоль, нет синхронизации можду потоками

        myThread1.start();
        myClass_2.start();

        Thread thread = new Thread() {              
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " " + "Cоздание с помощю ананимного классa");
            }
        };
        thread.start();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + "Создание с помощю функционального интерфейса");
            }
        };
        Thread thread1 = new Thread(task);
        thread1.start();
        

        Runnable task1 = ()-> System.out.println(Thread.currentThread().getName()+ " " + "Создание с помощю функционального интерфейса и лямбда");
        Thread thread2 = new Thread(task1);
        thread2.start();


        new Thread(() -> System.out.println(Thread.currentThread().getName()+ " " + "Cоздание с помощю ананимного классa и лямбда")).start();

    }
}

