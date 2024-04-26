package lesson_21_Multithreading.by_ChuckNorris.P_Callable_and_Future_iterfaces;

public class FactorialRunnable implements Runnable {
    int number;

    public FactorialRunnable(int number) {
        this.number = number;
    }

    // у кода есть недостатки
    // приходится использовать переменную вне FactorialRunnable, что бы передать result т к метод run() ничего не возвращает!!!!
    // в run() нельзя выбросить исключение, не позволяет это сделать

    @Override
    public void run() {
        if (number <= 0) {
            System.out.println("Number is not correct");
            // сдесь могло бы быть исключение вместо принт, если ктото введет неверное число
            return;
        }
        int result = 1;

        for (int i = 1;i<= number; i++){
            result *= i;
        }
        MainRunnable.factorialResult = result;
    }
}
