package Lesson_4.Classes.optionl_class;

import java.util.Optional;

// СМ еще Lesson 16_5
//Класс Optional был введен в Java 8 и представляет собой контейнер для объекта,
// который может содержать или не содержать ненулевое значение.
// Основная цель класса Optional - предоставить типовое решение для представления необязательных значений
// вместо нулевых ссылок.
//
//Вот некоторые основные преимущества использования Optional:
//
//Улучшает читаемость кода: Optional делает ваш код более ясным, поскольку факты, которые были скрыты, теперь видны разработчику2.
//Помогает избежать NullPointerException: Optional может помочь в написании аккуратного кода без использования множества проверок на null2.
//Позволяет указывать альтернативные значения для возврата или альтернативный код для выполнения
public class Main {
    public static void main(String[] args) {
        String someString = "какая то строка";
        Optional<String> optional = Optional.ofNullable(someString);
        optional.ifPresent(System.out::println);

        String someString1 = null;
        Optional<String> optional1 = Optional.ofNullable(someString1);
        optional1.ifPresent(System.out::println);


        //В этом примере, если someString не null, то его значение будет выведено на консоль.
        // Если someString равна null, то ничего не произойдет,
        // так как Optional позволяет безопасно обрабатывать потенциально нулевые значения.
    }
}
