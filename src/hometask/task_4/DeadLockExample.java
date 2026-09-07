package hometask.task_4;

public class DeadLockExample {
    private static final Object RESOURCE_A = new Object();
    private static final Object RESOURCE_B = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (RESOURCE_A) {
                System.out.println("Поток 1: захватил ресурс A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Поток 1: пытается захватить ресурс B");
                synchronized (RESOURCE_B) {
                    System.out.println("Поток 1: захватил оба ресурса");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (RESOURCE_B) {
                System.out.println("Поток 2: захватил ресурс B");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Поток 2: пытается захватить ресурс A");
                synchronized (RESOURCE_A) {
                    System.out.println("Поток 2: захватил оба ресурса");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}