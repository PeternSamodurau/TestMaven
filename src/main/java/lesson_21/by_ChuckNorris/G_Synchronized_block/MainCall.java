package lesson_21.by_ChuckNorris.G_Synchronized_block;

public class MainCall {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new RunnableMobile());
        Thread thread2 = new Thread(new RunnableSkype());
        Thread thread3 = new Thread(new RunnableViber());

        thread1.start();
        thread2.start();
        thread3.start();

        // сразу начнуться звонки одновременно повсем системам и закончаться, а нам надо по очереди


    }
}
