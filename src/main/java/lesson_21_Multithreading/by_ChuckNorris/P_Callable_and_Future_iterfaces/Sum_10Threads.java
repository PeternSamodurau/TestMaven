package lesson_21_Multithreading.by_ChuckNorris.P_Callable_and_Future_iterfaces;

import java.util.concurrent.Callable;

public class Sum_10Threads implements Callable<Long> {
    long from;
    long to;
    long localSum;

    public Sum_10Threads(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call(){

        for (long i = from; i<= to; i++){

            localSum+=i;
        }

        System.out.println(Thread.currentThread().getName() +
                " Sum From " +
                String.format("%,d", from).replace(',', '_') +
                " to " +
                String.format("%,d", to).replace(',', '_') +
                " = " +
                String.format("%,d", localSum).replace(',', '_'));

        return localSum;
    }
}
