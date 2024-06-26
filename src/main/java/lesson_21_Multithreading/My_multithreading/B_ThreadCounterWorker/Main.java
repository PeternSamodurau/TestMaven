package lesson_21_Multithreading.My_multithreading.B_ThreadCounterWorker;

//Многопоточность может увеличить производительность, но это не всегда так.
// Вот несколько причин, по которым многопоточное выполнение может быть медленнее:
//
//Переключение контекста: Когда процессор переключается между потоками,
// он должен сохранять и восстанавливать состояние потока, что требует времени.

//Синхронизация: Если потоки совместно используют ресурсы (например, данные),
// им может потребоваться синхронизация доступа к этим ресурсам, чтобы избежать проблем с конкуренцией.
// Операции синхронизации могут быть дорогостоящими с точки зрения производительности.

//Распределение ресурсов: Если у вас есть больше активных потоков, чем ядер процессора,
// то эти потоки должны делить ресурсы процессора между собой.
// Это может привести к тому, что каждый отдельный поток получит меньше времени процессора.

//Зависимость данных: Если один поток должен ждать завершения работы другого потока перед тем,
// как продолжить свою работу (например, из-за зависимости данных), это может привести к задержкам.

//Важно помнить, что многопоточность — это инструмент, и как и любой инструмент, его нужно использовать правильно.
// Если задача или данные не подходят для параллельной обработки, то многопоточность может не принести ожидаемых преимуществ.
// Поэтому всегда важно тщательно проектировать и тестировать многопоточные программы.

public class Main {
    public static void main(String[] args) {
        ThreadCounterWorker tcw1 = new ThreadCounterWorker("A", 15);
        ThreadCounterWorker tcw2 = new ThreadCounterWorker("B", 1000);
        long start = System.currentTimeMillis();

        // МНОГОПОТОЧНАЯ ОБРАБОТКА
        tcw1.start();                // скорость с использованием потоков 7-8 сек почему читай выше
        tcw2.start();
       // tcw1.run();                 без потоков скорость 5,7-6 сек
       // tcw2.run();

        try {
            //метода join(), который блокирует текущий поток (в данном случае, основной поток),
            // пока не завершится поток, для которого был вызван метод join()
            // Ожидание завершения обоих потоков
            tcw1.join();
            tcw2.join();                    //если отключить, то System.out.println("Время выполнения: " + finish); выведется в середине после завершения потока tcw1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long finish = System.currentTimeMillis() - start;
        System.out.println("Время выполнения: " + finish);
    }
}
