package src.question10;

class Console {
    public volatile int[] val;
    public volatile int index = 0;

    Console(int[] val) {
        this.val = val;
    }

    public void log() throws InterruptedException {
        String threadName = Thread.currentThread().getName();

        synchronized (this) {
            while (index < val.length) {
                if ((threadName == "Even" && val[index] % 2 == 0) || (threadName == "Odd" && val[index] % 2 != 0)) {
                    System.out.println("Thread--->" + threadName + ":" + val[index]);
                    index += 1;
                    notify();
                } else {
                    wait();
                }

            }
        }

    }
}

class MyThread extends Thread {
    public Console console;

    MyThread(Console c) {
        console = c;
    }

    @Override
    public void run() {
        try {
            console.log();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Threads2 extends Thread {

    public static void main(String[] args) {
        int MAXSIZE = 10;
        int[] largeArray = new int[MAXSIZE];

        for (int i = 0; i < MAXSIZE; i++) {
            largeArray[i] = i + 1;
        }

        // Printer is being shared among 2 threads
        // Synchronization is necessary
        Console console = new Console(largeArray);

        Thread th1 = new MyThread(console);
        Thread th2 = new MyThread(console);

        th1.setName("Even");
        th2.setName("Odd");

        th1.start();
        th2.start();

    }

}
