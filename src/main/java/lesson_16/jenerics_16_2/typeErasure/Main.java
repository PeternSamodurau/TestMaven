package lesson_16.jenerics_16_2.typeErasure;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Type erasure - стирание типов
    // для поддержки обратной совместимости кода без дженериков
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();    // мы пишем так
        int i = integerList.get(0);
        //  но jvm приводит к   List integerList = new ArrayList();  для поддержания кода
        // int i = (Integer) integerList.get(0);
    }
}
