package Lesson_17.count;

// count - считает количество элементов в стриме и возвращает long

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Integer> integerStream1 = Stream.of(54, 6 ,9,7, 7,54,9,8);
        long value1 = integerStream1.count();
       // long value2 = integerStream1.distinct().count();           // стрим нельзя переиспользовать, он закрывается, будет исключение IllegalStateException

        System.out.println("Количество элементов в стриме");
        System.out.println(value1);
        System.out.println("Количество уникальных элементов в стриме");


    }
}
