package hometask.task_4;

public class AlternatingPrinter {
    private static final Object MONITOR = new Object();
    private static volatile boolean isFirst = true;
    private static final int DELAY_MS = 1000;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    while (!isFirst) {
                        try {
                            MONITOR.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("1 ");
                    isFirst = false;

                    try {
                        Thread.sleep(DELAY_MS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    MONITOR.notify();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    while (isFirst) {
                        try {
                            MONITOR.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("2 ");
                    isFirst = true;

                    try {
                        Thread.sleep(DELAY_MS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    MONITOR.notify();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}