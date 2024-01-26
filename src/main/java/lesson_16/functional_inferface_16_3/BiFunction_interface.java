package lesson_16.functional_inferface_16_3;

import java.util.function.BiFunction;

public class BiFunction_interface {
    //Функциональный интерфейс — это интерфейс,который содержит ровно один абстрактный метод,то есть описание метода без тела.
    // Статические методы static и методы по умолчанию default при этом не в счёт, их в функциональном интерфейсе может быть сколько угодно.
    //Когда параметром метода является функциональный интерфейс, при вызове этого метода одним из аргументов должен быть блок кода
    public static void main(String[] args) {

        //функциональный интерфейс BiFunction
        int a = 5;
        int b = 3;

        //с помощью метода
        int result = calculater(a, b, new java.util.function.BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return a + b;
            }
        });
        System.out.println(result);

        // с помоью лямбда
        BiFunction<Integer, Integer, Integer> biFunction = (integer, integer2) -> integer * integer2;
        System.out.println(biFunction.apply(a, b));

    }

    private static int calculater(int a, int b, BiFunction<Integer, Integer, Integer> action) {
        return action.apply(a, b);
    }
}
