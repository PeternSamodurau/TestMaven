package Lesson_17.peek;

import java.util.stream.IntStream;

//Метод peek в Java Stream API используется для выполнения операции над каждым элементом потока и возвращения нового потока,
// который содержит элементы исходного потока.
// Он принимает Consumer (функцию, которая принимает один аргумент и не возвращает результат) в качестве аргумента
public class Main {
    public static void main(String[] args) {

       "abcd".chars()                                    // получаем IntStream из строки
                .peek(c-> System.out.print("char:" + (char) c))
                .forEach(i-> System.out.print(" - " + i + ",") );

    }
}
