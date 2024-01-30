package Lesson_17.Parallel_Sream;

import java.util.ArrayList;
import java.util.List;

//Parallel Stream - это возможность использования нескольких ядер процессора при выполнении каких либо операций со stream
// если елементов много 1,2,3,4 ..... 1 000 000 000 и умножить последовательно, то один процессот 1-250 000 000, второй 250 000 000 - 500 000 000 и тд
// потом 4 результата перемножаются
// многопоточность исполнять не надо
public class Main {
    public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.3);
        doubleList.add(11.3);
        doubleList.add(12.3);
        doubleList.add(13.3);
        doubleList.add(14.3);
        doubleList.add(15.3);


        double division = doubleList.stream().reduce((accumulator, element) -> accumulator /element).get();
        System.out.println(division);

        double division1 = doubleList.parallelStream().reduce((accumulator, element) -> accumulator /element).get();  // другой результат - неправильный нарушена последовательность деления
        System.out.println(division1);
    }
}
