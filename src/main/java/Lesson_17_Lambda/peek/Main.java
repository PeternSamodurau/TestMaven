package Lesson_17_Lambda.peek;

import java.util.stream.Stream;

//Метод peek в Java Stream API используется для выполнения операции над каждым элементом потока и возвращения нового потока,
// который содержит элементы исходного потока.
// Он принимает Consumer (функцию, которая принимает один аргумент и не возвращает результат) в качестве аргумента
public class Main {
    public static void main(String[] args) {

       "abcd".chars()                                    // получаем IntStream из строки
                .peek(c-> System.out.print("char:" + (char) c))
                .forEach(i-> System.out.print(" - " + i + ",") );

        Stream<Integer> integerStream1 = Stream.of(54, 6 ,9,7, 7,54,9,8);

        System.out.println("Количество уникальных элементов в стриме");
        System.out.println(integerStream1.distinct().peek(System.out::println).count()); //сначала оставили уникальные, с помощью peek() смотрим какие остались и возвращаем новый поток,
        // потом считаем сколько там элементов -5

    }
}
