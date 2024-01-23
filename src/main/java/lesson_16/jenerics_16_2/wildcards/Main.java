package lesson_16.jenerics_16_2.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// cсупер сильная карта типа джокер
public class Main {
    public static void main(String[] args) {
        List<?> list = new ArrayList<>();                  //можно написать так - может быть все
        //list.add("asf");                                   //добавить не получится любой тип, тип не определен

        showListInfo(Arrays.asList("Petr","Alla"));
        showListInfo(Arrays.asList(35,45));

        List<Number> list1 = Arrays.asList(10,25.3,5);
        System.out.println(sum(list1));
    }
    static void showListInfo (List<?> list){
        System.out.println(list);                        //метод будет выводить лист любых параметров

    }
    //метод находит сумму всех элементов любых параметров, листа если они Number
    public static double sum(List<? extends Number> list){
        double sum = 0;
        for (Number n: list) {
            sum+= n.doubleValue();
        }
        return sum;
    }
}
