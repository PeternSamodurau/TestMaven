package lesson_21.by_Skillbox.StringBuffer_class_21_11;

import java.util.ArrayList;

public class Main {

    //private static StringBuilder builder = new StringBuilder();        // будет ошибка но редко
    private static StringBuffer builder = new StringBuffer();        //  ошибки не будет, класс StringBuffer потокобезопасен, но замедляет работу


    public static void main(String[] args) {

        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++){

            threadArrayList.add(new Thread(()->{

                for (int j = 0; j < 100000; j ++){
                    builder.append("A");
                }

                System.out.println(builder.length());

            }));
        }
        threadArrayList.forEach(Thread::start);
    }
}
