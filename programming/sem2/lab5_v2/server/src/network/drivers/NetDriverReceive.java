package network.drivers;
import network.container.NetworkContainer;
import java.io.IOException;

@FunctionalInterface
public interface NetDriverReceive<T> {
    NetworkContainer<byte[], T> receive() throws IOException;
}
