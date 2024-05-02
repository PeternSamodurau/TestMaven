package A_Recurshion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(2));
    }

    private static int factorial(int x) {

        if (x == 1) {
            return 1;
        }
        return x * factorial(x - 1);
    }
}
// Call stack стэк вызовов

//Вызывается factorial(4).
// Поскольку 4 != 1, функция продолжает работу и вызывает factorial(3). Вычисление factorial(4) приостанавливается, пока factorial(3) не будет вычислено.
//Теперь вызывается factorial(3).
// Поскольку 3 != 1, функция продолжает работу и вызывает factorial(2). Вычисление factorial(3) приостанавливается, пока factorial(2) не будет вычислено.
//Затем вызывается factorial(2).
// Поскольку 2 != 1, функция продолжает работу и вызывает factorial(1). Вычисление factorial(2) приостанавливается, пока factorial(1) не будет вычислено.

//Наконец, вызывается factorial(1). Поскольку 1 == 1, функция возвращает 1.

//Теперь factorial(1) было вычислено, и его значение (которое равно 1) подставляется обратно в factorial(2).
// Таким образом, factorial(2) теперь равно 2 * 1 = 2.
//Значение factorial(2) (которое теперь равно 2) подставляется обратно в factorial(3).
// Таким образом, factorial(3) теперь равно 3 * 2 = 6.
//Наконец, значение factorial(3) (которое теперь равно 6) подставляется обратно в factorial(4).
// Таким образом, factorial(4) теперь равно 4 * 6 = 24.
//Таким образом, factorial(4) возвращает 24, что является правильным ответом. Это и есть работа стека вызовов в рекурсивной функции.