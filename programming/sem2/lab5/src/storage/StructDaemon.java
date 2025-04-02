package storage;

import storage.acess.StructAccess;
import storage.acess.StructQueue;
import storage.struct.Struct;

class MyRunnable implements Runnable {
    public void run() {
        StructQueue sq = new StructQueue();
        Struct st = new Struct();
        StructAccess sa = new StructAccess(st, sq);
        while (true){
            if (!sa.hasAnyUnhandledTasks()){
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex) {}
            }
            else {
                sa.runTask();
            }
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