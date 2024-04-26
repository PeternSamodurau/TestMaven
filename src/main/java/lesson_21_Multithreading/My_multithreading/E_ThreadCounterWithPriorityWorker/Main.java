package lesson_21_Multithreading.My_multithreading.E_ThreadCounterWithPriorityWorker;

public class Main {
    public static void main(String[] args) {
        ThreadCounterWithPriorityWorker tcw1 = new ThreadCounterWithPriorityWorker("A", 5, 10);
        ThreadCounterWithPriorityWorker tcw2 = new ThreadCounterWithPriorityWorker("B", 5, 1);


        // МНОГОПОТОЧНАЯ ОБРАБОТКА
        tcw1.start();
        tcw2.start();

        // НЕ ГАРАНТИРУЕТСЯ ПОРЯДОК ТК ПОРЯДОК ОПРЕДЕЛЯЕТСЯ ОС
        System.out.println("Process is finished!!!");
    }
}
