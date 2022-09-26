package task3;

public class Main {
    public static int myCounter = 50;

    public static void main(String[] args) throws InterruptedException {

        Thread priorityRunner = new Thread(new PriorityRunner());
        Thread priorityThread = new Thread(new PriorityThread());

        Thread iAmWaveThread = Thread.currentThread();

        priorityRunner.setPriority(1);
        priorityThread.setPriority(10);

        priorityRunner.start();
        priorityThread.start();

        System.out.println("Hello I am stream " + iAmWaveThread.getName());
        for (int i = 0; i < myCounter; i++) {
            int sl = 500 + i;
            Thread.sleep(sl);
            System.out.println("I am stream " + iAmWaveThread.getName() + " work in cycle, my priority " + iAmWaveThread.getPriority() + " my i = " + i + " I am sleep " + sl + " milliS ");
        }

        System.out.println("------------ " + iAmWaveThread.getName() +" FINISH ------------ ");
    }
}

class PriorityRunner implements Runnable {


    @Override
    public void run() {

        Thread iAmWaveThread = Thread.currentThread();
        iAmWaveThread.setName("PriorityRunner");
        System.out.println("Hello I am stream " + iAmWaveThread.getName());

        for (int r = 0; r < Main.myCounter; r++) {
            try {
                int sl = 500 + r;
                Thread.sleep(sl);
                System.out.println("I am stream " + iAmWaveThread.getName() + " working in a cycle, my priority " + iAmWaveThread.getPriority() + " my r = " + r + " I am sleep " + sl + " milliS ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------ " + iAmWaveThread.getName() +" FINISH ------------ ");
    }
}

class PriorityThread extends Thread {

    public void run() {

        Thread iAmWaveThread = Thread.currentThread();
        iAmWaveThread.setName("PriorityThread");
        System.out.println("Hello " + iAmWaveThread.getName());

        for (int t = 0; t < Main.myCounter; t++) {
            try {
                int sl = 500 + t;
                Thread.sleep(sl);
                System.out.println("I am stream " + iAmWaveThread.getName() + " working in a cycle, my priority " + iAmWaveThread.getPriority() + " my t = " + t + " I am sleep " + sl + " milliS ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------ " + iAmWaveThread.getName() +" FINISH ------------");
    }
}
