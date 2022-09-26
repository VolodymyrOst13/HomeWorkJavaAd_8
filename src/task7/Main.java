package task7;

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

    synchronized void getOneClass(int i) {
        Thread iAmWaveThread = Thread.currentThread();
        System.out.println("I am stream " + iAmWaveThread.getName() + " Print - " + i);
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
            s.getOneClass(i);
        }
    }
}
