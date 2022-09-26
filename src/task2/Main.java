package task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(new FirstThread());
        Thread second = new Thread(new SecondThread());
        Thread third = new Thread(new ThirdThread());
        first.start();
        second.start();
        third.start();
    }

}

class FirstThread extends Thread {

    public void run() {

        for (int j = 0; j < 5; j++) {
            try {
                Thread.sleep(2000);
                System.out.println("Thread 1 run = " + j + " ---------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------- Thread 1 FINISH ---------");
    }
}

class SecondThread extends Thread {
    public void run() {
        for (int j = 0; j < 5; j++) {
            try {
                Thread.sleep(3000);
                System.out.println("Thread 2 run = " + j + " ---------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------- Thread 2 FINISH ---------");
    }
}

class ThirdThread extends Thread {
    public void run() {
        for (int j = 0; j < 5; j++) {
            try {
                Thread.sleep(1000);
                System.out.println("Thread 3 run = " + j + " ---------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------- Thread 3 FINISH ---------");
    }
}
