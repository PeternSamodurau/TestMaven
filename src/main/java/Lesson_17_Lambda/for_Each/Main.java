package Lesson_17_Lambda.for_Each;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,5};

        Arrays.stream(array).forEach(System.out::println);

        System.out.println("_______________________________");

        Arrays.stream(array).forEach(value -> {
            value *= 2;
            System.out.println(value);
        });

        System.out.println("_______________________________");
        Arrays.stream(array).forEach(a -> Utils.someMethod(a));                    // с методом

    }
}
