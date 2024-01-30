package Lesson_17.distinct;

// distinct - возвращает стрим уникальных элементов

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Integer> integerStream1 = Stream.of(54, 6 ,9, 7, 7, 54);

        Stream<Integer> integerStream = integerStream1.distinct();        // уникальные элементы
        integerStream.forEach(System.out::println);
    }
}
