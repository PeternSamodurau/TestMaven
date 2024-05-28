package A_Recurshion;

import java.util.Random;

// посчитать сумму элементов рекурсивно
public class Sum_numbers_in_array {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] array = new int[3];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000); // Генерирует случайные числа в диапазоне от 0 до 999
        }

        long start = System.nanoTime();
       //подсчет циклом
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println(sum);
        long finish = System.nanoTime() - start ;

        System.out.println(finish);

        long start1 = System.nanoTime();
        System.out.println(sumRec(0,0,array));
        long finish1 = System.nanoTime() - start1 ;

        System.out.println(finish1);
    }

    //без цикла через рекурсию
    private static int sumRec(int i, int sum, int[] array) {

        if (i == array.length) {
            return sum;
        } else {
            return sumRec(i + 1, sum + array[i], array);
        }
    }
}
//Шаг 1: Метод sumRec вызывается с i = 0, sum = 0 и array = {2, 3, 4}.
// Поскольку i не равно длине массива, метод возвращает sumRec(1, 0 + array[0], array), что равно sumRec(1, 2, array).

//Шаг 2: Теперь метод sumRec вызывается с i = 1, sum = 2 и array = {2, 3, 4}.
// Поскольку i все еще не равно длине массива, метод возвращает sumRec(2, 2 + array[1], array), что равно sumRec(2, 5, array).

//Шаг 3: Метод sumRec вызывается с i = 2, sum = 5 и array = {2, 3, 4}.
// Поскольку i все еще не равно длине массива, метод возвращает sumRec(3, 5 + array[2], array), что равно sumRec(3, 9, array).

//Шаг 4: Наконец, метод sumRec вызывается с i = 3, sum = 9 и array = {2, 3, 4}. Теперь i равно длине массива, поэтому метод возвращает sum, то есть 9.