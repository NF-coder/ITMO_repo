package server;

import server.core.Engine;

public class ServerCycle implements Runnable {
    public void run(){
        Engine engine = new Engine();
        while (true){
            engine.mainCycle();
        }
    }
}
