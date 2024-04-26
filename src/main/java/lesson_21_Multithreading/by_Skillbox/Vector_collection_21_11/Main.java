package lesson_21_Multithreading.by_Skillbox.Vector_collection_21_11;

import java.util.ArrayList;
import java.util.Vector;

public class Main {

  //  private static ArrayList<Double> numbers = new ArrayList<>();         // БЫЛО не работает
    private static Vector<Double> numbers = new Vector<>();         // ИСПОЛЬЗУЕМ потокобезопасную коллекцию Vector


    public static void main(String[] args) {

        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++){

            threadArrayList.add(new Thread(()->{

                for (int j = 0; j < 100000; j ++){
                     numbers.add(Math.random()/Math.random());
                }

                System.out.println(numbers.size());

            }));
        }
        threadArrayList.forEach(Thread::start);
    }
}
