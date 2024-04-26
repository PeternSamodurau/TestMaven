package lesson_21_Multithreading.by_ChuckNorris.A_Multithreading;

// чаще вместо extends Thread  используют implements Runnable, тк интерфейсов может быть много, отсутствует множественное наследование

public class MyClass_1 implements Runnable {
    //метод не может быть статическим - нужен обьеке класса в main
    // переопределяется метод run()
    @Override
   public void run(){
        for (int i = 0 ; i <1000 ; i++){
            System.out.println(Thread.currentThread().getName()+ " " + i);
        }
    }
}
