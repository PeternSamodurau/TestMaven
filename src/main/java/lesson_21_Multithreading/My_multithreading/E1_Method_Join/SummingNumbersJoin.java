package lesson_21_Multithreading.My_multithreading.E1_Method_Join;

import java.util.stream.IntStream;

public class SummingNumbersJoin implements Runnable {

    private static final int INITIAL_VALUE_RESULT_NUMBER = 0;

    private final int fromNumber;
    private final int toNumber;
    private int resultNumber;

    public SummingNumbersJoin(int fromNumber, int toNumber) {
        this.fromNumber = fromNumber;
        this.toNumber = toNumber;
        this.resultNumber = INITIAL_VALUE_RESULT_NUMBER;
    }

    public int getResultNumber() {
        return resultNumber;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(fromNumber,toNumber).forEach(i -> resultNumber += i);
        //IntStream.rangeClosed(fromNumber, toNumber): Этот метод генерирует последовательность целых чисел от fromNumber до toNumber (включительно).
        // Например, если fromNumber равно 1, а toNumber равно 5, то он сгенерирует поток чисел: 1, 2, 3, 4, 5.

        //.forEach(i -> resultNumber += i): Это лямбда-выражение, которое применяется к каждому элементу в потоке.
        // В данном случае, каждое число i в потоке добавляется к resultNumber. Это эквивалентно  циклу for (int i = fromNumber; i <= toNumber; i++){resultNumber += i;}

        MainSummingNumbersJoin.printThreadNameAndNumber(resultNumber);
    }
}
