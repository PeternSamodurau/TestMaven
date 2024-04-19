package lesson_21.My_multithreading.D_ThreadWithSleepCounterWorker;

public class MainSummingNumbersSleep {
    private static final int FROM_NUMBER_FIRST_THREAD = 1;
    private static final int TO_NUMBER_FIRST_THREAD = 500;

    private static final int FROM_NUMBER_SECOND_THREAD = 501;
    private static final int TO_NUMBER_SECOND_THREAD = 1000;

    private static final String MASSAGE_THREAD_NAME_AND_NUMBER = "%s : %d\n";

    private static final int TIME_SLEEP_IN_MILLIS = 1000;

    public static void main(String[] args) {

        SummingNumbersSleep firstTask = startTask(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIRST_THREAD);

        SummingNumbersSleep secondTask = startTask(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);

        // поток main сработает быстрее  resultNumber = 0  вызываем метод sleepThread() ;

        sleepThread();

        //применять метод sleep не стоит из за его ненадежности, так как неизвестно время срабатывания потока, его или не хватит, или будет простой

        final int resultNumber = firstTask.getResultNumber() + secondTask.getResultNumber();

        printThreadNameAndNumber(resultNumber);

    }

    private static void sleepThread() {
        try {
            Thread.sleep(TIME_SLEEP_IN_MILLIS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static SummingNumbersSleep startTask(int fromNumber, int toNumber) {
        SummingNumbersSleep task = new SummingNumbersSleep(fromNumber, toNumber);
        Thread thread = new Thread(task);
        thread.start();
        return task;
    }

    public static void printThreadNameAndNumber(int number) {
        System.out.printf(MASSAGE_THREAD_NAME_AND_NUMBER, Thread.currentThread().getName(), number);
    }

}
