package lesson_21_Multithreading.by_ChuckNorris.P_Callable_and_Future_iterfaces;

import java.util.concurrent.Callable;

// Callable возвращает значение и позволяет выбрасывать исключение

public class FactorialCallable implements Callable<Integer> {

    int number;

    public FactorialCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {

        if (number <= 0) {
          throw new IllegalArgumentException("Number is not correct");
        }
        int result = 1;

        for (int i = 1;i<= number; i++){
            result *= i;
        }
        return result;
    }
}
//В данном случае, исключение IllegalArgumentException выбрасывается намеренно, чтобы указать на некорректное использование метода.
// Если число меньше или равно нулю, это указывает на то, что метод call() был вызван неправильно.
//
//Обработка исключения обычно происходит в том коде, который вызывает метод, в данном случае call().
// Это позволяет вызывающему коду решить, что делать в случае исключения.
// Например, он может записать ошибку в лог, повторить попытку с другим числом или прервать выполнение программы.