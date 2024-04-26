package lesson_21_Multithreading.My_multithreading.E1_Method_Join;

public class MainSummingNumbersJoin {
    private static final int FROM_NUMBER_FIRST_THREAD = 1;
    private static final int TO_NUMBER_FIRST_THREAD = 500;

    private static final int FROM_NUMBER_SECOND_THREAD = 501;
    private static final int TO_NUMBER_SECOND_THREAD = 1000;

    private static final String MASSAGE_THREAD_NAME_AND_NUMBER = "%s : %d\n";

    public static void main(String[] args) {

        SummingNumbersJoin firstTask = new SummingNumbersJoin(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIRST_THREAD);
        SummingNumbersJoin secondTask = new SummingNumbersJoin(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);

        Thread thread = new Thread(firstTask);
        Thread thread1 = new Thread(secondTask);

        thread.start();
        thread1.start();

        joinThread(thread,thread1);

        final int resultNumber = firstTask.getResultNumber() + secondTask.getResultNumber();

        printThreadNameAndNumber(resultNumber);

    }
    // код использует так называемые “varargs” (variable number of arguments) в Java, обозначаемые тремя точками ... после типа параметра.
    // Это позволяет передавать в метод произвольное количество аргументов одного типа.
    // В вашем случае это Thread... threads, что означает, что метод joinThread может принимать любое количество объектов Thread.

    private static void joinThread(Thread... threads) {
        for (Thread thread : threads ){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printThreadNameAndNumber(int number) {
        System.out.printf(MASSAGE_THREAD_NAME_AND_NUMBER, Thread.currentThread().getName(), number);
    }

}
