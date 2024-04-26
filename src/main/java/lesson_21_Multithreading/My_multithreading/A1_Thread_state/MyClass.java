package lesson_21_Multithreading.My_multithreading.A1_Thread_state;

class MyClass implements Runnable {
    @Override
    public void run() {
        Main.printThreadState(Thread.currentThread());   // состояние потока 0 RUNNABLE
        synchronized (Main.lock) {
            Main.printThreadState(Thread.currentThread());  // // состояние потока 0 RUNNABLE
            while (Main.isRunning) {
                try {
                    Main.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
