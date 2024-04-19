package lesson_21.by_ChuckNorris.M_Interruption_thread;

public class SomeClass extends Thread{

    double sqrSum = 0;

    @Override
    public void run(){
        for (int i = 1; i<= 1_000_000_000;i++){

            sqrSum += Math.sqrt(i);

            if (isInterrupted()){
                System.out.println("Поток хотят прервать");
                System.out.println("Проверка состояния обьектов, прерывание потока ");
                System.out.println(sqrSum  + "  !!!");
                return;
            }

            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна, завершим его работу");
                System.out.println(sqrSum + "  !!!");
                return;
            }
        }
        System.out.println(sqrSum);
    }
}
