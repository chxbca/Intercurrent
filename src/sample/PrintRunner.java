package sample;

import java.util.Date;

class PrintRunner {
    private static Thread thread;
    private static boolean stop, pause;

    static Thread threadFactory() {
        stop = false;
        pause = false;
        thread = new Thread(() -> {
            try {
                while (true) {
                    if (stop) {
                        System.out.printf("%s结束运行…………%s%n", Thread.currentThread().getName(), new Date());
                        return;
                    }

                    synchronized (PrintRunner.class) {
                        if (pause) {
                            System.out.printf("%s暂停运行…………%s%n", Thread.currentThread().getName(), new Date());
                            PrintRunner.class.wait();
                        } else {
                            System.out.printf("%s正在运行…………%s%n", Thread.currentThread().getName(), new Date());
                        }
                    }

                    if (stop) {
                        System.out.printf("%s结束运行…………%s%n", Thread.currentThread().getName(), new Date());
                        return;
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        return thread;
    }

    static void setPause(boolean flag) {
        pause = flag;
    }

    static void destroy() {
        synchronized (PrintRunner.class) {
            stop = true;
            PrintRunner.class.notify();
        }
    }

    static boolean isAlive() {
        return thread.isAlive();
    }

    static boolean isEmpty() {
        return thread == null;
    }
}
