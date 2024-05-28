package lesson_21_Multithreading.My_multithreading.Z_ForkJoinPool;

import java.util.concurrent.ForkJoinPool;

//Данный код выполняет расчет суммы чисел в заданном диапазоне, используя технологию Fork/Join в Java.
//
//Fork/Join - это фреймворк, предназначенный для эффективного выполнения больших задач, которые можно разбить на более мелкие подзадачи.
// Он использует принцип “разделяй и властвуй” для выполнения подзадач в отдельных потоках, а затем объединяет результаты.
// Принцип “разделяй и властвуй” - это подход к решению сложных задач, который включает разделение задачи на более мелкие подзадачи до тех пор,
// пока они не станут достаточно простыми для решения непосредственно.
// Затем решения подзадач объединяются для получения решения исходной задачи.
// В данном коде, задача - это подсчет суммы чисел в диапазоне от start = 1 до end = 10000.
// Если диапазон меньше или равен 1000, задача выполняется в одном потоке.
// Если диапазон больше 1000, задача разбивается на две подзадачи, каждая из которых выполняется в своем потоке.
// Результаты подзадач затем объединяются для получения окончательного результата.
//
//В итоге, этот код позволяет эффективно использовать многопроцессорность для ускорения вычислений.
public class Main {
    public static void main(String[] args) {
        // Создание пула потоков равным количеству доступных процессоров для выполнения задач
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        // Начальное и конечное значение диапазона чисел
        long start = 1;
        long end = 10000;

        // Создание задачи для подсчета суммы чисел в указанном диапазоне
        MyTask task = new MyTask(start, end);

        // Запуск задачи в пуле потоков и получение результата
        long result = forkJoinPool.invoke(task);

        //Метод invoke в классе ForkJoinPool используется для выполнения задачи типа ForkJoinTask.
        // Этот метод выполняет заданную задачу и возвращает результат ее выполнения.
        //
        //Вот как он работает:
        //
        //Метод invoke запускает выполнение задачи в пуле потоков.
        //Он ожидает завершения задачи и возвращает результат ее выполнения.
        //В контексте вашего кода, forkJoinPool.invoke(task) запускает выполнение задачи task,
        // которая вычисляет сумму чисел в заданном диапазоне, и возвращает эту сумму.
        //
        //Важно отметить, что метод invoke является блокирующим, что означает, что он блокирует текущий поток до тех пор,
        // пока задача не будет выполнена и результат не будет возвращен


        System.out.println("Sum of numbers from " + start + " to " + end + ": " + result);
    }
}
