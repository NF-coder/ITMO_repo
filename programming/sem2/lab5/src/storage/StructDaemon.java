package storage;

class MyRunnable implements Runnable {
    public void run() {
        while (true){
            System.out.println("test");
        }
    }
}

public class StructDaemon {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable); // Создаем новый поток
        thread.start(); // Запускаем новый поток
    }
}