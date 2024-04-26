package lesson_21_Multithreading.by_ChuckNorris.A_Multithreading;

public class MyClass_2 extends Thread {

    //метод не может быть статическим - нужен обьеке клосса в main
    // переопределяется метод run()
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(Thread.currentThread().getName()+ " " +i);
        }
    }
}
