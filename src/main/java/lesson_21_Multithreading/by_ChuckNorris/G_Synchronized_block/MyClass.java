package lesson_21_Multithreading.by_ChuckNorris.G_Synchronized_block;

//В этом коде MyClass myClass = new MyClass(); создает один экземпляр класса MyClass.
// Затем этот экземпляр передается в 10 разных потоков.
// Когда вы используете synchronized (this), this ссылается на этот конкретный экземпляр myClass.
//
//Таким образом, все 10 потоков синхронизируются на одном и том же объекте myClass.
// Это означает, что только один из этих потоков может выполнять синхронизированный блок кода в любой момент времени.
// Остальные потоки будут ожидать, пока текущий поток не завершит выполнение синхронизированного блока.
// Это помогает предотвратить проблемы с состоянием гонки при обновлении значения count.

public class MyClass implements Runnable {

    private int count = 0;

    private void increment() {

        System.out.print("ура ");               // не синхронизированная часть кода все потоки исполняют

    synchronized (this) {                         // синхронизация на обьекте класса MyClass myClass = new MyClass() чей монитор будем использовать
                                                  // если метод статический, то синхронизация по классу MyClass.class
            count++;
            System.out.print(count + " ");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();                                  // КАЖДЫЙ ПОТОК ЗАХОДИТ 3 РАЗА
        }
    }
}

