package Lesson_17_Lambda.reduce;

//Reduce - уменьшить, метод позволяет выполнить агрегацию элементов потока (сведение их в одно значение)

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,5,8,2);

        int result = integerList.stream().reduce((accumulator, element) -> accumulator * element).get();  // reduce возвращает Optionl, если лист будет пустой, будет исключение
        System.out.println(result);
        //   accumulator = ((((1*2)*5)*8)*2) = 160

//        List<Integer> integerList1 = Arrays.asList();    // создадим пустой лист
//        int result1 = integerList1.stream().reduce((accumulator, element) -> accumulator * element).get();  // исключение NoSuchElementException
//        System.out.println(result1);

        System.out.println("Напишим проверку");

        List<Integer> integerList2 = Arrays.asList(10,5, 5); // создадим лист
        Optional<Integer> optional = integerList2.stream().reduce((accumulator, element) -> accumulator * element);
        if (optional.isPresent()){
            System.out.println(optional.get());       //теперь исключение NoSuchElementException не выбрасывается
        }else {
            System.out.println("Not present");
        }

        System.out.println("можно указать начальное значение - 1 здесь");
        int result2 = integerList.stream().reduce(3,(accumulator, element) -> accumulator * element);
        //result2 = ((((1*3)*2)*5)*8)*2) = 480
        System.out.println(result2);

        System.out.println("канкатинация стрингов");
        List<String> stringList = Arrays.asList("Hello", "World" , "!!!");

        String result3 = stringList.stream().reduce((a,e)-> a + " " + e).get();
        System.out.println(result3);


    }
}
