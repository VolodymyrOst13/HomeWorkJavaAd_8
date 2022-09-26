package task6;

public class Main {
    public static void main(String[] args) {
        MySynchro s = new MySynchro();
        Thread first = new Thread(new OneClass(s));
        Thread second = new Thread(new SecondClass(s));
        first.start();
        second.start();
    }
}

class MySynchro {

    boolean aBoolean;

    synchronized void getOneClass(int i) {

        Thread iAmWaveThread = Thread.currentThread();
        iAmWaveThread.setName(" Class 1 ");
        if (aBoolean) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("I am stream " + iAmWaveThread.getName() + " Print - " + i);
        aBoolean = true;
        notify();
    }

    synchronized void getSecondClass(int i) {
        Thread iAmWaveThread = Thread.currentThread();
        iAmWaveThread.setName(" Class 2 ");
        if (!aBoolean) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("I am stream " + iAmWaveThread.getName() + " Print - " + i);
        aBoolean = false;
        notify();
    }
}

class OneClass extends Thread {
    MySynchro s;

    public OneClass(MySynchro s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            if (i % 2 == 0) {
                s.getOneClass(i);
            }
        }
    }
}

class SecondClass extends Thread {

    MySynchro s;

    public SecondClass(MySynchro s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            s.getSecondClass(i);
        }
    }
}
