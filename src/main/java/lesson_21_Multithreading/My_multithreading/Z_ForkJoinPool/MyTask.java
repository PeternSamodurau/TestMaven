package lesson_21_Multithreading.My_multithreading.Z_ForkJoinPool;

import java.util.concurrent.RecursiveTask;

//RecursiveTask является подклассом ForkJoinTask. Это значит, что любой экземпляр RecursiveTask также является экземпляром ForkJoinTask.
//
//Таким образом, когда вы создаете экземпляр MyTask и передаете его в метод invoke пула ForkJoinPool, вы на самом деле передаете задачу ForkJoinTask.
//
//ForkJoinTask - это абстрактный класс, который представляет вычислительную задачу, предназначенную для выполнения в пуле ForkJoinPool.
// RecursiveTask - это специализированный подкласс ForkJoinTask, который возвращает результат.
// В вашем случае, MyTask возвращает сумму чисел в заданном диапазоне.

public class MyTask extends RecursiveTask<Long> {
    private final long start;
    private final long end;

    public MyTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    //Метод invoke в ForkJoinPool запускает выполнение задачи ForkJoinTask,
// которая в вашем случае является экземпляром класса MyTask.
//
//Внутри MyTask, метод compute определяет, как именно должна выполняться задача.
// Этот метод вызывается автоматически, когда вы вызываете invoke на ForkJoinPool с вашей задачей.
//
//Так что, когда вы вызываете forkJoinPool.invoke(task), это приводит к вызову метода compute внутри вашего объекта task.
// Это и есть место, где происходит всё вычисление - подсчет суммы чисел в заданном диапазоне.
//
//Таким образом, можно сказать, что invoke запускает compute, но через механизм ForkJoinPool.
// Это позволяет ForkJoinPool управлять деталями параллелизма и эффективно распределять работу между потоками.
    @Override
    protected Long compute() {
        if (end - start <= 1000) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;
            MyTask leftTask = new MyTask(start, mid);
            MyTask rightTask = new MyTask(mid + 1, end);

            leftTask.fork();
            long rightResult = rightTask.compute();
            long leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}
//Если диапазон чисел меньше или равен 1000: Задача выполняется в одном потоке. Метод compute() просто суммирует все числа в диапазоне и возвращает сумму.
//Если диапазон чисел больше 1000: Задача разбивается на две подзадачи.
// Метод compute() делит диапазон чисел пополам и создает две новые задачи MyTask для каждой половины диапазона.
// Одна задача (leftTask) запускается в новом потоке с помощью метода fork().
// Вторая задача (rightTask) выполняется в текущем потоке с помощью вызова compute().
// Затем метод join() вызывается для leftTask, чтобы получить результат, когда он станет доступен.
// Результаты обеих задач затем суммируются и возвращаются.
//Таким образом, метод compute() позволяет эффективно распараллеливать вычисления, разбивая большие задачи на меньшие подзадачи,
// которые могут выполняться параллельно.