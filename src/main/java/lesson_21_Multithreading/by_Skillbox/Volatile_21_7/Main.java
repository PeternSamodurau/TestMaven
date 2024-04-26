package lesson_21_Multithreading.by_Skillbox.Volatile_21_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Task task = new Task();
        new Thread(task).start();

        Scanner scanner = new Scanner(System.in);         // поток не завершится пока не нажмем ввод
        scanner.nextLine();
        task.stop();

        // но программа не остановилась, не пеатается Task nr как true не поменялось на false
        // делаем переменную volatile

        System.out.println("Main: " + task.getCounter());
    }
}
