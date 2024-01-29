package Lesson_17.Stream_17_2;

//Stream - поток данных, последовательность элементов, поддерживающих последодовательные и параллельные операции над ними

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream <Integer> emptyStream = Stream.empty();   //пустой

        Stream<String> stream = Stream.of("a","b","c"); //- на основе перечисления

        List<Double> doubleList = List.of(1D,2D,3D); //- на основе Collection
        Stream<Double> stream1 = doubleList.stream();   // стрим чисел double

        Map<String,Integer> map = Map.of("one",1,"two",2); //-на основе Map,коллекция Set
        Stream<Map.Entry<String,Integer>> stream2 = map.entrySet().stream();

        double[] arr = new double[]{3.4,6.4}; //- из массива
        DoubleStream stream3 = Arrays.stream(arr);
        stream3.forEach(System.out::println);
        System.out.println("___________________________________");

        Stream<Double> stream5 = Stream.generate(Math::random).limit(5);;      // - конечный рандомный стрим
        stream5.forEach(System.out::println);
        System.out.println("___________________________________");

      //  Stream.generate(()-> Math.random()).forEach(System.out::println);;            // -бесконечный рандомный стрим

        IntStream.range(0,10).forEach(System.out::println);                             // аналог цикла

    }
}
