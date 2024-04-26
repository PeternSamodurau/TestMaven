package lesson_21_Multithreading.by_Skillbox.DeadLock_21_12;

public class Main {

    public static void main(String[] args) {

        final Friend vasya = new Friend("Вася");
        final Friend kolya = new Friend("Коля");

        new Thread(()-> vasya.throwBallTo(vasya)).start();
        new Thread(()-> kolya.throwBallTo(kolya)).start();

    }
}
