package lesson_16.jenerics_16_2.begin;

//Дженерикисоздали для безопасности ипов данных
//В программировании дженерики - это обобщенные типы данных, которые позволяют работать с разными типами данных, используя один и тот же код
// есть jenerics - классы,конструкторы, интерфейсы, методы

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // раньше небыло дженериков и в List можно было запихнуть все

        List list = new ArrayList();
        list.add("fsfg");
        list.add(4646464);
        // при переборе будет ошибка исключения .ClassNotFoundException
        for (int i = 0; i< list.size(); i++){
            int item = (Integer) list.get(i);
            System.out.println(item);
        }
        //ТАК НЕ ПИШУТ!!!!!!!!!!!!!!!!!
    }
}

