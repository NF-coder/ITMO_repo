package server.core.promise;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalizedPromises {
    Deque<Promise> finishedOperations = new ArrayDeque<>();

    public void add(Promise promise){
        this.finishedOperations.addLast(promise);
    }

    public Promise get(){
        return finishedOperations.pollFirst();
    }

    public boolean isEmpty(){
        return finishedOperations.isEmpty();
    }
}
