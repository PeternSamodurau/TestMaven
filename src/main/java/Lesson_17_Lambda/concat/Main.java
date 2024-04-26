package Lesson_17_Lambda.concat;

import java.util.stream.Stream;

// CONCAT - обьединяет стримы в стрим

public class Main {
    public static void main(String[] args) {

        Stream<Integer> integerStream1 = Stream.of(54, 6 ,9, 7);
        Stream<Integer> integerStream2 = Stream.of(5, 6 ,10, 7);

        Stream<Integer> integerStream = Stream.concat(integerStream1, integerStream2);
        integerStream.forEach(System.out::println);
    }
}
