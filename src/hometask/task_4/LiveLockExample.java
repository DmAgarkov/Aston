package hometask.task_4;

import java.util.concurrent.atomic.AtomicBoolean;

public class LiveLockExample {
    private static final Object RESOURCE_A = new Object();
    private static final Object RESOURCE_B = new Object();
    private static final AtomicBoolean stopFlag = new AtomicBoolean(false);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (!stopFlag.get()) {
                synchronized (RESOURCE_A) {
                    System.out.println("Поток 1: захватил A, пробую захватить B");

                    if (tryLock(RESOURCE_B)) {
                        System.out.println("Поток 1: захватил оба ресурса");
                        stopFlag.set(true);
                        break;
                    } else {
                        System.out.println("Поток 1: не смог захватить B, отпускаю A и повторяю");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (!stopFlag.get()) {
                synchronized (RESOURCE_B) {
                    System.out.println("Поток 2: захватил B, пробую захватить A");

                    if (tryLock(RESOURCE_A)) {
                        System.out.println("Поток 2: захватил оба ресурса");
                        stopFlag.set(true);
                        break;
                    } else {
                        System.out.println("Поток 2: не смог захватить A, отпускаю B и повторяю");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private static boolean tryLock(Object resource) {
        try {
            return Thread.holdsLock(resource);
        } catch (Exception e) {
            return false;
        }
    }
}