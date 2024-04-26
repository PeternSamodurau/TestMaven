package lesson_21_Multithreading.by_ChuckNorris.I_DadLock_LiveLock_LockStarvation;

//DeadLock - ситуация, когда 2 или более потоков залочены навсегда, ожидают друг друга и ничего не делают
//LiveLock - ситуация когда 2 илиболее потоков залочены навсегда, ожидают друг друга, проделывают какуюто работу, но без какго либо прогресса, кода нет
//LockStarvation - ситуация, когда менее преорететные потоки ждут долгое время или все время чтобы запуститься, кода нет

public class Main {
    public static void main(String[] args) {

       MyClass1 myClass1 = new MyClass1();
       MyClass2 myClass2 = new MyClass2();

       Thread thread1 = new Thread(myClass1);
       Thread thread2 = new Thread(myClass2);

       thread1.start();
       thread2.start();

       //все виснет на - попытка захватить монитор бъекта .....
    }
}
